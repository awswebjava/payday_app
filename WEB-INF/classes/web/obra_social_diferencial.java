package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obra_social_diferencial extends GXProcedure
{
   public obra_social_diferencial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obra_social_diferencial.class ), "" );
   }

   public obra_social_diferencial( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           String aP5 ,
                           boolean aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           java.math.BigDecimal[] aP8 ,
                           java.math.BigDecimal[] aP9 ,
                           String[] aP10 ,
                           String[] aP11 )
   {
      obra_social_diferencial.this.aP12 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        byte[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 )
   {
      obra_social_diferencial.this.AV17CliCod = aP0;
      obra_social_diferencial.this.AV9EmpCod = aP1;
      obra_social_diferencial.this.AV16LiqNro = aP2;
      obra_social_diferencial.this.AV10LegNumero = aP3;
      obra_social_diferencial.this.AV25LiqPeriodo = aP4;
      obra_social_diferencial.this.AV15ProcesoLiquidacion = aP5;
      obra_social_diferencial.this.AV12insertandoConceptos = aP6;
      obra_social_diferencial.this.aP7 = aP7;
      obra_social_diferencial.this.aP8 = aP8;
      obra_social_diferencial.this.aP9 = aP9;
      obra_social_diferencial.this.aP10 = aP10;
      obra_social_diferencial.this.aP11 = aP11;
      obra_social_diferencial.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV18auxConCodigo ;
      GXt_char2 = AV18auxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_obrasocial_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      obra_social_diferencial.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char2, GXv_char4) ;
      obra_social_diferencial.this.GXt_char1 = GXv_char4[0] ;
      AV18auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV28os_LiqDImpCalcu ;
      GXv_boolean6[0] = false ;
      GXv_int7[0] = AV14auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV17CliCod, AV9EmpCod, AV16LiqNro, AV10LegNumero, AV18auxConCodigo, AV15ProcesoLiquidacion, AV12insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      obra_social_diferencial.this.AV28os_LiqDImpCalcu = GXv_decimal5[0] ;
      obra_social_diferencial.this.AV14auxLiqDCalculado = GXv_int7[0] ;
      if ( AV14auxLiqDCalculado == 0 )
      {
         AV8LiqDCalculado = (byte)(0) ;
         AV19error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV18auxConCodigo) ;
         AV20LiqDLog = GXutil.trim( AV19error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char2 = AV18auxConCodigo ;
      GXt_char1 = AV18auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).execute( GXv_char4) ;
      obra_social_diferencial.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char1, GXv_char3) ;
      obra_social_diferencial.this.GXt_char2 = GXv_char3[0] ;
      AV18auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV13LiqDImpCalcu ;
      GXv_boolean6[0] = false ;
      GXv_int7[0] = AV14auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV17CliCod, AV9EmpCod, AV16LiqNro, AV10LegNumero, AV18auxConCodigo, AV15ProcesoLiquidacion, AV12insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      obra_social_diferencial.this.AV13LiqDImpCalcu = GXv_decimal5[0] ;
      obra_social_diferencial.this.AV14auxLiqDCalculado = GXv_int7[0] ;
      if ( AV14auxLiqDCalculado == 0 )
      {
         AV8LiqDCalculado = (byte)(0) ;
         AV19error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV18auxConCodigo) ;
         AV20LiqDLog = GXutil.trim( AV19error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV27baseLiqDImpCalcu = AV13LiqDImpCalcu ;
      AV21Importes = AV13LiqDImpCalcu ;
      AV20LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV21Importes, 14, 2)) + httpContext.getMessage( " correspondiente a la base de cálculo diferencial de aportes OS y FSR (concepto ", "") + GXutil.trim( AV18auxConCodigo) + ")" ;
      if ( AV21Importes.doubleValue() > 0 )
      {
         AV24palabra = "[apo_OS_ali]" ;
         GXv_char4[0] = AV22OpeCliValor ;
         GXv_char3[0] = AV29auxError ;
         new web.getopeclivalor(remoteHandle, context).execute( AV17CliCod, AV24palabra, AV25LiqPeriodo, AV15ProcesoLiquidacion, GXv_char4, GXv_char3) ;
         obra_social_diferencial.this.AV22OpeCliValor = GXv_char4[0] ;
         obra_social_diferencial.this.AV29auxError = GXv_char3[0] ;
         if ( ! (GXutil.strcmp("", AV29auxError)==0) )
         {
            AV8LiqDCalculado = (byte)(0) ;
            AV19error = AV29auxError ;
            AV20LiqDLog = AV19error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV23porUnaje = CommonUtil.decimalVal( AV22OpeCliValor, ".") ;
         AV21Importes = AV21Importes.multiply(AV23porUnaje) ;
         AV20LiqDLog += httpContext.getMessage( ". Multiplica por alícuota de aporte de obra social ", "") + GXutil.trim( GXutil.str( AV23porUnaje, 6, 4)) ;
         AV21Importes = AV21Importes.subtract(AV28os_LiqDImpCalcu) ;
         AV20LiqDLog += httpContext.getMessage( ". Resta importe de obra social ", "") + GXutil.trim( GXutil.str( AV28os_LiqDImpCalcu, 14, 2)) ;
      }
      AV26cantidadCalculada = AV23porUnaje.multiply(DecimalUtil.doubleToDec(100)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = obra_social_diferencial.this.AV21Importes;
      this.aP8[0] = obra_social_diferencial.this.AV27baseLiqDImpCalcu;
      this.aP9[0] = obra_social_diferencial.this.AV26cantidadCalculada;
      this.aP10[0] = obra_social_diferencial.this.AV19error;
      this.aP11[0] = obra_social_diferencial.this.AV20LiqDLog;
      this.aP12[0] = obra_social_diferencial.this.AV8LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21Importes = DecimalUtil.ZERO ;
      AV27baseLiqDImpCalcu = DecimalUtil.ZERO ;
      AV26cantidadCalculada = DecimalUtil.ZERO ;
      AV19error = "" ;
      AV20LiqDLog = "" ;
      AV18auxConCodigo = "" ;
      AV28os_LiqDImpCalcu = DecimalUtil.ZERO ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      AV13LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      AV24palabra = "" ;
      AV22OpeCliValor = "" ;
      GXv_char4 = new String[1] ;
      AV29auxError = "" ;
      GXv_char3 = new String[1] ;
      AV23porUnaje = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV14auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV17CliCod ;
   private int AV16LiqNro ;
   private int AV10LegNumero ;
   private java.math.BigDecimal AV21Importes ;
   private java.math.BigDecimal AV27baseLiqDImpCalcu ;
   private java.math.BigDecimal AV26cantidadCalculada ;
   private java.math.BigDecimal AV28os_LiqDImpCalcu ;
   private java.math.BigDecimal AV13LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV23porUnaje ;
   private String AV15ProcesoLiquidacion ;
   private String AV18auxConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String AV24palabra ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV25LiqPeriodo ;
   private boolean AV12insertandoConceptos ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private String AV20LiqDLog ;
   private String AV22OpeCliValor ;
   private String AV19error ;
   private String AV29auxError ;
   private byte[] aP12 ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
}

