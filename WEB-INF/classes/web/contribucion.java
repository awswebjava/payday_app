package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class contribucion extends GXProcedure
{
   public contribucion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( contribucion.class ), "" );
   }

   public contribucion( int remoteHandle ,
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
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 )
   {
      contribucion.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        byte[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 )
   {
      contribucion.this.AV10CliCod = aP0;
      contribucion.this.AV24EmpCod = aP1;
      contribucion.this.AV23LiqNro = aP2;
      contribucion.this.AV18LegNumero = aP3;
      contribucion.this.AV11LiqPeriodo = aP4;
      contribucion.this.AV12ProcesoLiquidacion = aP5;
      contribucion.this.AV25palabra = aP6;
      contribucion.this.aP7 = aP7;
      contribucion.this.aP8 = aP8;
      contribucion.this.aP9 = aP9;
      contribucion.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV19auxConCodigo ;
      GXt_char2 = AV19auxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.parametro_concepto_lsd_importeadetraer(remoteHandle, context).execute( GXv_char3) ;
      contribucion.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      contribucion.this.GXt_char1 = GXv_char4[0] ;
      AV19auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV27detraerLiqDImpCalcu ;
      GXv_boolean6[0] = AV20existe ;
      GXv_int7[0] = AV21auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV24EmpCod, AV23LiqNro, AV18LegNumero, AV19auxConCodigo, AV12ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      contribucion.this.AV27detraerLiqDImpCalcu = GXv_decimal5[0] ;
      contribucion.this.AV20existe = GXv_boolean6[0] ;
      contribucion.this.AV21auxLiqDCalculado = GXv_int7[0] ;
      if ( AV27detraerLiqDImpCalcu.doubleValue() <= 0 )
      {
         AV16LiqDLog = httpContext.getMessage( "No se calcula porque el importe a detraer es nulo", "") ;
      }
      else
      {
         if ( ( GXutil.strcmp(AV25palabra, httpContext.getMessage( "JUBILACION", "")) == 0 ) || ( GXutil.strcmp(AV25palabra, httpContext.getMessage( "PAMI", "")) == 0 ) )
         {
            GXv_char4[0] = AV19auxConCodigo ;
            new web.getparametro(remoteHandle, context).execute( AV10CliCod, new web.parametro_concepto_lsd_baseimponible2(remoteHandle, context).executeUdp( ), GXv_char4) ;
            contribucion.this.AV19auxConCodigo = GXv_char4[0] ;
         }
         else if ( ( GXutil.strcmp(AV25palabra, httpContext.getMessage( "FNE", "")) == 0 ) || ( GXutil.strcmp(AV25palabra, httpContext.getMessage( "AAFF", "")) == 0 ) )
         {
            GXv_char4[0] = AV19auxConCodigo ;
            new web.getparametro(remoteHandle, context).execute( AV10CliCod, new web.parametro_concepto_lsd_baseimponible3(remoteHandle, context).executeUdp( ), GXv_char4) ;
            contribucion.this.AV19auxConCodigo = GXv_char4[0] ;
         }
         GXv_decimal5[0] = AV22auxLiqDImpCalcu ;
         GXv_boolean6[0] = AV20existe ;
         GXv_int7[0] = AV21auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV24EmpCod, AV23LiqNro, AV18LegNumero, AV19auxConCodigo, AV12ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         contribucion.this.AV22auxLiqDImpCalcu = GXv_decimal5[0] ;
         contribucion.this.AV20existe = GXv_boolean6[0] ;
         contribucion.this.AV21auxLiqDCalculado = GXv_int7[0] ;
         GXv_char4[0] = AV29ConDescrip ;
         GXv_boolean6[0] = AV20existe ;
         new web.conceptogetdescri2(remoteHandle, context).execute( AV10CliCod, AV19auxConCodigo, GXv_char4, GXv_boolean6) ;
         contribucion.this.AV29ConDescrip = GXv_char4[0] ;
         contribucion.this.AV20existe = GXv_boolean6[0] ;
         if ( ! AV20existe )
         {
            if ( (GXutil.strcmp("", AV19auxConCodigo)==0) )
            {
               AV15error = httpContext.getMessage( "Error de parametrización de concepto para base imponible de ", "") + GXutil.trim( AV25palabra) ;
            }
            else
            {
               AV15error = httpContext.getMessage( "El concepto ", "") + GXutil.trim( AV19auxConCodigo) + httpContext.getMessage( " parametrizado como base imponible de ", "") + GXutil.trim( AV25palabra) + httpContext.getMessage( " no existe", "") ;
            }
            AV16LiqDLog = GXutil.trim( AV15error) ;
            AV8LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV26Importes = AV22auxLiqDImpCalcu ;
         AV16LiqDLog = httpContext.getMessage( "Inicializa con ", "") + GXutil.trim( GXutil.str( AV26Importes, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( AV29ConDescrip) ;
         AV26Importes = AV26Importes.subtract(AV27detraerLiqDImpCalcu) ;
         AV16LiqDLog += httpContext.getMessage( ". Resta importe a detraer ", "") + GXutil.trim( GXutil.str( AV27detraerLiqDImpCalcu, 14, 2)) ;
         AV9auxOpeCliId = "[base_imp_min]" ;
         GXv_char4[0] = AV13OpeCliValor ;
         GXv_char3[0] = AV14auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV10CliCod, AV9auxOpeCliId, AV11LiqPeriodo, AV12ProcesoLiquidacion, GXv_char4, GXv_char3) ;
         contribucion.this.AV13OpeCliValor = GXv_char4[0] ;
         contribucion.this.AV14auxError = GXv_char3[0] ;
         if ( ! (GXutil.strcmp("", AV14auxError)==0) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            AV15error = AV14auxError ;
            AV16LiqDLog = GXutil.trim( AV15error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV17base_imp_min = CommonUtil.decimalVal( AV13OpeCliValor, ".") ;
         if ( DecimalUtil.compareTo(AV26Importes, AV17base_imp_min) < 0 )
         {
            AV26Importes = AV17base_imp_min ;
            AV16LiqDLog += httpContext.getMessage( ". Establece valor en base imponible mínima ", "") + GXutil.trim( GXutil.str( AV26Importes, 14, 2)) ;
         }
         GXv_decimal5[0] = AV28porUnaje ;
         GXv_char4[0] = AV14auxError ;
         new web.getprccontrtipoempl(remoteHandle, context).execute( AV10CliCod, AV24EmpCod, AV25palabra, AV11LiqPeriodo, AV12ProcesoLiquidacion, GXv_decimal5, GXv_char4) ;
         contribucion.this.AV28porUnaje = GXv_decimal5[0] ;
         contribucion.this.AV14auxError = GXv_char4[0] ;
         if ( ! (GXutil.strcmp("", AV14auxError)==0) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            AV15error = GXutil.trim( AV14auxError) ;
            AV16LiqDLog = GXutil.trim( AV15error) ;
         }
         AV26Importes = AV26Importes.multiply(AV28porUnaje) ;
         AV16LiqDLog += httpContext.getMessage( ". Multiplica por alícuota ", "") + GXutil.trim( GXutil.str( AV28porUnaje, 6, 4)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = contribucion.this.AV26Importes;
      this.aP8[0] = contribucion.this.AV16LiqDLog;
      this.aP9[0] = contribucion.this.AV8LiqDCalculado;
      this.aP10[0] = contribucion.this.AV15error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26Importes = DecimalUtil.ZERO ;
      AV16LiqDLog = "" ;
      AV15error = "" ;
      AV19auxConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      AV27detraerLiqDImpCalcu = DecimalUtil.ZERO ;
      AV22auxLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_int7 = new byte[1] ;
      AV29ConDescrip = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV9auxOpeCliId = "" ;
      AV13OpeCliValor = "" ;
      AV14auxError = "" ;
      GXv_char3 = new String[1] ;
      AV17base_imp_min = DecimalUtil.ZERO ;
      AV28porUnaje = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV21auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV24EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV23LiqNro ;
   private int AV18LegNumero ;
   private java.math.BigDecimal AV26Importes ;
   private java.math.BigDecimal AV27detraerLiqDImpCalcu ;
   private java.math.BigDecimal AV22auxLiqDImpCalcu ;
   private java.math.BigDecimal AV17base_imp_min ;
   private java.math.BigDecimal AV28porUnaje ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV12ProcesoLiquidacion ;
   private String AV25palabra ;
   private String AV19auxConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String AV9auxOpeCliId ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV20existe ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private String AV16LiqDLog ;
   private String AV13OpeCliValor ;
   private String AV15error ;
   private String AV29ConDescrip ;
   private String AV14auxError ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private byte[] aP9 ;
}

