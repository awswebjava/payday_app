package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ganancia_neta_tope extends GXProcedure
{
   public ganancia_neta_tope( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ganancia_neta_tope.class ), "" );
   }

   public ganancia_neta_tope( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 ,
                             byte[] aP8 )
   {
      ganancia_neta_tope.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 ,
                        byte[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 ,
                             byte[] aP8 ,
                             String[] aP9 )
   {
      ganancia_neta_tope.this.AV8CliCod = aP0;
      ganancia_neta_tope.this.AV16EmpCod = aP1;
      ganancia_neta_tope.this.AV15LiqNro = aP2;
      ganancia_neta_tope.this.AV14LegNumero = aP3;
      ganancia_neta_tope.this.AV24LiqPeriodo = aP4;
      ganancia_neta_tope.this.AV10ProcesoLiquidacion = aP5;
      ganancia_neta_tope.this.aP6 = aP6;
      ganancia_neta_tope.this.aP7 = aP7;
      ganancia_neta_tope.this.aP8 = aP8;
      ganancia_neta_tope.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV9auxConCodigo ;
      GXt_char2 = AV9auxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.remuneraciongravada_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      ganancia_neta_tope.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      ganancia_neta_tope.this.GXt_char1 = GXv_char4[0] ;
      AV9auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV13auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV11existe ;
      GXv_int7[0] = AV12auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV16EmpCod, AV15LiqNro, AV14LegNumero, AV9auxConCodigo, AV10ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      ganancia_neta_tope.this.AV13auxLiqDImpCalcu = GXv_decimal5[0] ;
      ganancia_neta_tope.this.AV11existe = GXv_boolean6[0] ;
      ganancia_neta_tope.this.AV12auxLiqDCalculado = GXv_int7[0] ;
      if ( AV12auxLiqDCalculado == 0 )
      {
         AV19error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9auxConCodigo) ;
         AV20LiqDLog = GXutil.trim( AV19error) ;
         AV17LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV18Importes = AV13auxLiqDImpCalcu ;
      AV20LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " de remuneración gravada", "") ;
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_dedprimasegucodigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_dedsepelio_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_dedviaticorre_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_vehicorre_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_dedalquiler_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_dedcredhipoteca_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_dedrecipro_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_deddome_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.concepto_dedindumentaria_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV21restarConCodigo.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.gastosdeeducacion_codigoparam(remoteHandle, context).executeUdp( )), 0);
      AV22i = (short)(1) ;
      while ( AV22i <= AV21restarConCodigo.size() )
      {
         AV9auxConCodigo = (String)AV21restarConCodigo.elementAt(-1+AV22i) ;
         GXv_decimal5[0] = AV13auxLiqDImpCalcu ;
         GXv_boolean6[0] = AV11existe ;
         GXv_int7[0] = AV12auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV16EmpCod, AV15LiqNro, AV14LegNumero, AV9auxConCodigo, AV10ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         ganancia_neta_tope.this.AV13auxLiqDImpCalcu = GXv_decimal5[0] ;
         ganancia_neta_tope.this.AV11existe = GXv_boolean6[0] ;
         ganancia_neta_tope.this.AV12auxLiqDCalculado = GXv_int7[0] ;
         GXv_char4[0] = AV23ConDescrip ;
         new web.conceptogetdescri(remoteHandle, context).execute( AV8CliCod, AV9auxConCodigo, GXv_char4) ;
         ganancia_neta_tope.this.AV23ConDescrip = GXv_char4[0] ;
         if ( AV12auxLiqDCalculado == 0 )
         {
            AV19error = httpContext.getMessage( "Falta calcular concepto \"", "") + GXutil.trim( AV23ConDescrip) + "\"" ;
            AV20LiqDLog = GXutil.trim( AV19error) ;
            AV17LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV13auxLiqDImpCalcu)==0) )
         {
            AV18Importes = AV18Importes.subtract(AV13auxLiqDImpCalcu) ;
            AV25dedImportes = AV25dedImportes.add(AV13auxLiqDImpCalcu) ;
            AV20LiqDLog += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( AV13auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV23ConDescrip) ;
         }
         AV22i = (short)(AV22i+1) ;
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV25dedImportes)==0) )
      {
         AV20LiqDLog += httpContext.getMessage( ". No hay deducciones generales con tope para restar", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = ganancia_neta_tope.this.AV18Importes;
      this.aP7[0] = ganancia_neta_tope.this.AV20LiqDLog;
      this.aP8[0] = ganancia_neta_tope.this.AV17LiqDCalculado;
      this.aP9[0] = ganancia_neta_tope.this.AV19error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18Importes = DecimalUtil.ZERO ;
      AV20LiqDLog = "" ;
      AV19error = "" ;
      AV9auxConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      AV13auxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV21restarConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      AV23ConDescrip = "" ;
      GXv_char4 = new String[1] ;
      AV25dedImportes = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV17LiqDCalculado ;
   private byte AV12auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV16EmpCod ;
   private short AV22i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15LiqNro ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV18Importes ;
   private java.math.BigDecimal AV13auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV25dedImportes ;
   private String AV10ProcesoLiquidacion ;
   private String AV9auxConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV24LiqPeriodo ;
   private boolean AV11existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private String AV20LiqDLog ;
   private String AV19error ;
   private String AV23ConDescrip ;
   private String[] aP9 ;
   private java.math.BigDecimal[] aP6 ;
   private String[] aP7 ;
   private byte[] aP8 ;
   private GXSimpleCollection<String> AV21restarConCodigo ;
}

