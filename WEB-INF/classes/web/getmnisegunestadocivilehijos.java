package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmnisegunestadocivilehijos extends GXProcedure
{
   public getmnisegunestadocivilehijos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmnisegunestadocivilehijos.class ), "" );
   }

   public getmnisegunestadocivilehijos( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      getmnisegunestadocivilehijos.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      getmnisegunestadocivilehijos.this.AV13CliCod = aP0;
      getmnisegunestadocivilehijos.this.AV14EmpCod = aP1;
      getmnisegunestadocivilehijos.this.AV10LegNumero = aP2;
      getmnisegunestadocivilehijos.this.AV16LiqPeriodo = aP3;
      getmnisegunestadocivilehijos.this.AV17ProcesoLiquidacion = aP4;
      getmnisegunestadocivilehijos.this.AV25validar = aP5;
      getmnisegunestadocivilehijos.this.aP6 = aP6;
      getmnisegunestadocivilehijos.this.aP7 = aP7;
      getmnisegunestadocivilehijos.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV15LegEstadoCivil ;
      new web.getestadocivil(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV10LegNumero, GXv_int1) ;
      getmnisegunestadocivilehijos.this.AV15LegEstadoCivil = GXv_int1[0] ;
      GXv_boolean2[0] = AV21EstaCivilCasadoEs ;
      new web.getestadocivildeduce(remoteHandle, context).execute( AV15LegEstadoCivil, GXv_boolean2) ;
      getmnisegunestadocivilehijos.this.AV21EstaCivilCasadoEs = GXv_boolean2[0] ;
      GXv_char3[0] = AV22EstaCivilDescrip ;
      new web.getestadocivildescrip(remoteHandle, context).execute( AV15LegEstadoCivil, GXv_char3) ;
      getmnisegunestadocivilehijos.this.AV22EstaCivilDescrip = GXv_char3[0] ;
      AV8LiqDLog = httpContext.getMessage( "Estado civil \"", "") + GXutil.trim( AV22EstaCivilDescrip) ;
      GXv_char3[0] = AV11deduceConyugePalabra ;
      new web.deduceconyuge(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV10LegNumero, GXv_char3) ;
      getmnisegunestadocivilehijos.this.AV11deduceConyugePalabra = GXv_char3[0] ;
      if ( ! AV21EstaCivilCasadoEs && ( GXutil.strcmp(GXutil.trim( AV11deduceConyugePalabra), "0") != 0 ) )
      {
         AV20error = httpContext.getMessage( "Inconsistencia de datos, el estado civil es ", "") + GXutil.trim( AV22EstaCivilDescrip) + httpContext.getMessage( " y tiene familiar cargado con valor ", "") + GXutil.trim( AV11deduceConyugePalabra) + httpContext.getMessage( " en \"deduce conyuge\"", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         GXv_int1[0] = AV23cantHijos ;
         new web.cantidadhijoscondeduccion(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV10LegNumero, AV16LiqPeriodo, (short)(0), (short)(18), DecimalUtil.doubleToDec(0), GXv_int1) ;
         getmnisegunestadocivilehijos.this.AV23cantHijos = GXv_int1[0] ;
         AV8LiqDLog += httpContext.getMessage( ". Cantidad de hijos que deducen impuesto a las ganancias: ", "") + GXutil.trim( GXutil.str( AV23cantHijos, 4, 0)) ;
         if ( ! AV21EstaCivilCasadoEs || ( AV23cantHijos < 2 ) )
         {
            AV9OpeCliId = "[piso_ganancias_solteros]" ;
         }
         else
         {
            AV9OpeCliId = "[piso_ganancias_casados]" ;
         }
      }
      if ( AV25validar )
      {
         GXv_char3[0] = AV18OpeCliValor ;
         GXv_char4[0] = AV19auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV13CliCod, AV9OpeCliId, AV16LiqPeriodo, AV17ProcesoLiquidacion, GXv_char3, GXv_char4) ;
         getmnisegunestadocivilehijos.this.AV18OpeCliValor = GXv_char3[0] ;
         getmnisegunestadocivilehijos.this.AV19auxError = GXv_char4[0] ;
      }
      else
      {
         GXv_char4[0] = AV18OpeCliValor ;
         new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV13CliCod, AV9OpeCliId, AV16LiqPeriodo, AV17ProcesoLiquidacion, GXv_char4) ;
         getmnisegunestadocivilehijos.this.AV18OpeCliValor = GXv_char4[0] ;
      }
      if ( ! (GXutil.strcmp("", AV19auxError)==0) )
      {
         AV20error = GXutil.trim( AV19auxError) ;
         AV8LiqDLog = GXutil.trim( AV20error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV24Importes = CommonUtil.decimalVal( AV18OpeCliValor, ".") ;
      AV8LiqDLog += httpContext.getMessage( ". Inicializa valor de MNI con ", "") + GXutil.trim( AV18OpeCliValor) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getmnisegunestadocivilehijos.this.AV18OpeCliValor;
      this.aP7[0] = getmnisegunestadocivilehijos.this.AV8LiqDLog;
      this.aP8[0] = getmnisegunestadocivilehijos.this.AV20error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18OpeCliValor = "" ;
      AV8LiqDLog = "" ;
      AV20error = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV22EstaCivilDescrip = "" ;
      AV11deduceConyugePalabra = "" ;
      GXv_int1 = new short[1] ;
      AV9OpeCliId = "" ;
      GXv_char3 = new String[1] ;
      AV19auxError = "" ;
      GXv_char4 = new String[1] ;
      AV24Importes = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14EmpCod ;
   private short AV15LegEstadoCivil ;
   private short AV23cantHijos ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV10LegNumero ;
   private java.math.BigDecimal AV24Importes ;
   private String AV17ProcesoLiquidacion ;
   private String AV11deduceConyugePalabra ;
   private String AV9OpeCliId ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV16LiqPeriodo ;
   private boolean AV25validar ;
   private boolean AV21EstaCivilCasadoEs ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV18OpeCliValor ;
   private String AV8LiqDLog ;
   private String AV20error ;
   private String AV22EstaCivilDescrip ;
   private String AV19auxError ;
   private String[] aP8 ;
   private String[] aP6 ;
   private String[] aP7 ;
}

