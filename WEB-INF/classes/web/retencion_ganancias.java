package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class retencion_ganancias extends GXProcedure
{
   public retencion_ganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( retencion_ganancias.class ), "" );
   }

   public retencion_ganancias( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             byte[] aP11 )
   {
      retencion_ganancias.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        byte[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             byte[] aP11 ,
                             String[] aP12 )
   {
      retencion_ganancias.this.AV8CliCod = aP0;
      retencion_ganancias.this.AV10EmpCod = aP1;
      retencion_ganancias.this.AV12LiqNro = aP2;
      retencion_ganancias.this.AV50LiqRelNro = aP3;
      retencion_ganancias.this.AV11LegNumero = aP4;
      retencion_ganancias.this.AV49ConCodigo = aP5;
      retencion_ganancias.this.AV38LiqPeriodo = aP6;
      retencion_ganancias.this.AV35ProcesoLiquidacion = aP7;
      retencion_ganancias.this.AV36insertandoConceptos = aP8;
      retencion_ganancias.this.aP9 = aP9;
      retencion_ganancias.this.aP10 = aP10;
      retencion_ganancias.this.aP11 = aP11;
      retencion_ganancias.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV9alcanzaGananciasConConcodigo ;
      GXt_char2 = AV9alcanzaGananciasConConcodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      AV9alcanzaGananciasConConcodigo = GXt_char1 ;
      GXv_decimal5[0] = AV13alcanzaGananciasLiqDImpCalcu ;
      GXv_boolean6[0] = AV37existe ;
      GXv_int7[0] = AV14alcanzaLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV12LiqNro, AV11LegNumero, AV9alcanzaGananciasConConcodigo, AV35ProcesoLiquidacion, AV36insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      retencion_ganancias.this.AV13alcanzaGananciasLiqDImpCalcu = GXv_decimal5[0] ;
      retencion_ganancias.this.AV37existe = GXv_boolean6[0] ;
      retencion_ganancias.this.AV14alcanzaLiqDCalculado = GXv_int7[0] ;
      if ( ( AV14alcanzaLiqDCalculado == 0 ) && ( AV37existe ) )
      {
         AV16LiqDCalculado = (byte)(0) ;
         AV15error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9alcanzaGananciasConConcodigo) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( AV13alcanzaGananciasLiqDImpCalcu.doubleValue() == 0 )
      {
         AV17LiqDLog = httpContext.getMessage( "No se calcula IIGG porque así lo determina el resultado del concepto ", "") + GXutil.trim( AV9alcanzaGananciasConConcodigo) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXv_char4[0] = AV18esAgente ;
      new web.getlegajoagente(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV11LegNumero, GXv_char4) ;
      retencion_ganancias.this.AV18esAgente = GXv_char4[0] ;
      if ( CommonUtil.decimalVal( AV18esAgente, ".").doubleValue() == 0 )
      {
         AV17LiqDLog = httpContext.getMessage( "No se calcula IIGG porque la empresa no está marcada como agente de retención para el empleado", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char2 = AV39auxConCodigo ;
      GXt_char1 = AV39auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_baseimponible1(remoteHandle, context).execute( GXv_char4) ;
      retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
      AV39auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV40auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV37existe ;
      GXv_int7[0] = AV41auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV12LiqNro, AV11LegNumero, AV39auxConCodigo, AV35ProcesoLiquidacion, AV36insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      retencion_ganancias.this.AV40auxLiqDImpCalcu = GXv_decimal5[0] ;
      retencion_ganancias.this.AV37existe = GXv_boolean6[0] ;
      retencion_ganancias.this.AV41auxLiqDCalculado = GXv_int7[0] ;
      if ( AV41auxLiqDCalculado == 0 )
      {
         AV16LiqDCalculado = (byte)(0) ;
         AV15error = httpContext.getMessage( "Falta calcular concepto + ", "") ;
         GXutil.trim( AV39auxConCodigo) ;
         AV17LiqDLog = AV15error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( AV40auxLiqDImpCalcu.doubleValue() == 0 )
      {
         GXt_char2 = AV39auxConCodigo ;
         GXt_char1 = AV39auxConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.concepto_sueldobruto_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
         AV39auxConCodigo = GXt_char2 ;
         GXv_decimal5[0] = AV40auxLiqDImpCalcu ;
         GXv_boolean6[0] = AV37existe ;
         GXv_int7[0] = AV41auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV12LiqNro, AV11LegNumero, AV39auxConCodigo, AV35ProcesoLiquidacion, AV36insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         retencion_ganancias.this.AV40auxLiqDImpCalcu = GXv_decimal5[0] ;
         retencion_ganancias.this.AV37existe = GXv_boolean6[0] ;
         retencion_ganancias.this.AV41auxLiqDCalculado = GXv_int7[0] ;
         if ( AV41auxLiqDCalculado == 0 )
         {
            AV16LiqDCalculado = (byte)(0) ;
            AV15error = httpContext.getMessage( "Falta calcular concepto + ", "") ;
            GXutil.trim( AV39auxConCodigo) ;
            AV17LiqDLog = AV15error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV43netoImportes = AV40auxLiqDImpCalcu ;
         GXt_char2 = AV48devGanConCodigo ;
         GXt_char1 = AV48devGanConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.concepto_devolucionganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
         AV48devGanConCodigo = GXt_char2 ;
         AV46excluirConCodigo.add(AV48devGanConCodigo, 0);
         GXv_decimal5[0] = AV47descuentosImportes ;
         GXv_int7[0] = AV41auxLiqDCalculado ;
         new web.getimpliqportipo(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV12LiqNro, AV11LegNumero, AV38LiqPeriodo, "DES_ARG", AV49ConCodigo, AV35ProcesoLiquidacion, AV46excluirConCodigo, GXv_decimal5, GXv_int7) ;
         retencion_ganancias.this.AV47descuentosImportes = GXv_decimal5[0] ;
         retencion_ganancias.this.AV41auxLiqDCalculado = GXv_int7[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV53Pgmname, httpContext.getMessage( "falta desscuento ", "")+GXutil.trim( GXutil.str( AV41auxLiqDCalculado, 1, 0))) ;
         if ( AV41auxLiqDCalculado == 0 )
         {
            AV16LiqDCalculado = (byte)(0) ;
            AV15error = httpContext.getMessage( "Falta calcular descuentos", "") ;
            AV17LiqDLog = AV15error ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV43netoImportes = AV43netoImportes.subtract(AV47descuentosImportes) ;
         if ( AV43netoImportes.doubleValue() <= 0 )
         {
            AV17LiqDLog = httpContext.getMessage( "No se calcula IIGG porque la liquidación por netea en cero", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      GXt_char2 = AV19importeARetenerConConcodigo ;
      GXt_char1 = AV19importeARetenerConConcodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.importearetener_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
      AV19importeARetenerConConcodigo = GXt_char2 ;
      GXv_decimal5[0] = AV20importeARetenerLiqDImpCalcu ;
      GXv_boolean6[0] = AV37existe ;
      GXv_int7[0] = AV21importeARetenerLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV12LiqNro, AV11LegNumero, AV19importeARetenerConConcodigo, AV35ProcesoLiquidacion, AV36insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      retencion_ganancias.this.AV20importeARetenerLiqDImpCalcu = GXv_decimal5[0] ;
      retencion_ganancias.this.AV37existe = GXv_boolean6[0] ;
      retencion_ganancias.this.AV21importeARetenerLiqDCalculado = GXv_int7[0] ;
      if ( ( AV21importeARetenerLiqDCalculado == 0 ) && ( AV37existe ) )
      {
         AV16LiqDCalculado = (byte)(0) ;
         AV15error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV19importeARetenerConConcodigo) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( AV20importeARetenerLiqDImpCalcu.doubleValue() <= 0 )
      {
         AV22Importes = AV20importeARetenerLiqDImpCalcu ;
         if ( AV20importeARetenerLiqDImpCalcu.doubleValue() == 0 )
         {
            AV17LiqDLog = httpContext.getMessage( "No corresponde retención alguna porque el cálculo de importe a retener es igual a cero", "") ;
         }
         else
         {
            AV17LiqDLog = httpContext.getMessage( "El importe a retener es negativo, por lo que se refleja como una devolución de ganancias en el concepto correspondiente", "") ;
         }
      }
      else
      {
         GXt_char2 = AV23sueldoBrutoConConcodigo ;
         GXt_char1 = AV23sueldoBrutoConConcodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.concepto_sueldobrutomenosley_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
         AV23sueldoBrutoConConcodigo = GXt_char2 ;
         GXv_decimal5[0] = AV24sueldoBrutoLiqDImpCalcu ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean6[0] = AV37existe ;
         GXv_int7[0] = AV25sueldoBrutoLiqDCalculado ;
         new web.getliqdimpcalcuporperiodo(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV12LiqNro, AV50LiqRelNro, AV38LiqPeriodo, AV11LegNumero, AV23sueldoBrutoConConcodigo, AV35ProcesoLiquidacion, AV36insertandoConceptos, false, GXv_decimal5, GXv_decimal8, GXv_boolean6, GXv_int7) ;
         retencion_ganancias.this.AV24sueldoBrutoLiqDImpCalcu = GXv_decimal5[0] ;
         retencion_ganancias.this.AV37existe = GXv_boolean6[0] ;
         retencion_ganancias.this.AV25sueldoBrutoLiqDCalculado = GXv_int7[0] ;
         if ( ( AV25sueldoBrutoLiqDCalculado == 0 ) && ( AV37existe ) )
         {
            AV16LiqDCalculado = (byte)(0) ;
            AV15error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV23sueldoBrutoConConcodigo) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV26sueldo35PorCiento = AV24sueldoBrutoLiqDImpCalcu.multiply(DecimalUtil.stringToDec("0.35")) ;
         GXv_char4[0] = AV34importeARetenerConDescrip ;
         new web.conceptogetdescparalog(remoteHandle, context).execute( AV8CliCod, AV19importeARetenerConConcodigo, GXv_char4) ;
         retencion_ganancias.this.AV34importeARetenerConDescrip = GXv_char4[0] ;
         if ( DecimalUtil.compareTo(AV20importeARetenerLiqDImpCalcu, AV26sueldo35PorCiento) <= 0 )
         {
            AV22Importes = AV20importeARetenerLiqDImpCalcu ;
            AV17LiqDLog = httpContext.getMessage( "Se asigna valor de ", "") + GXutil.trim( AV34importeARetenerConDescrip) + httpContext.getMessage( " siempre que no exceda el 35% del sueldo ", "") ;
         }
         else
         {
            AV22Importes = AV26sueldo35PorCiento ;
            AV17LiqDLog = httpContext.getMessage( "Se retiene el 35% del sueldo por ser la retención calculada ", "") + GXutil.trim( GXutil.str( AV20importeARetenerLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " por el concepto ", "") + GXutil.trim( AV34importeARetenerConDescrip) + httpContext.getMessage( " mayor a este porcentaje", "") ;
         }
         if ( ! (GXutil.strcmp("", AV27formulaAfipLiqDLog)==0) )
         {
            AV17LiqDLog += httpContext.getMessage( ". Para el cálculo del importe inicial del impuesto ", "") + GXutil.trim( AV27formulaAfipLiqDLog) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = retencion_ganancias.this.AV22Importes;
      this.aP10[0] = retencion_ganancias.this.AV15error;
      this.aP11[0] = retencion_ganancias.this.AV16LiqDCalculado;
      this.aP12[0] = retencion_ganancias.this.AV17LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22Importes = DecimalUtil.ZERO ;
      AV15error = "" ;
      AV17LiqDLog = "" ;
      AV9alcanzaGananciasConConcodigo = "" ;
      AV13alcanzaGananciasLiqDImpCalcu = DecimalUtil.ZERO ;
      AV18esAgente = "" ;
      AV39auxConCodigo = "" ;
      AV40auxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV43netoImportes = DecimalUtil.ZERO ;
      AV48devGanConCodigo = "" ;
      AV46excluirConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47descuentosImportes = DecimalUtil.ZERO ;
      AV53Pgmname = "" ;
      AV19importeARetenerConConcodigo = "" ;
      AV20importeARetenerLiqDImpCalcu = DecimalUtil.ZERO ;
      AV23sueldoBrutoConConcodigo = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV24sueldoBrutoLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      AV26sueldo35PorCiento = DecimalUtil.ZERO ;
      AV34importeARetenerConDescrip = "" ;
      GXv_char4 = new String[1] ;
      AV27formulaAfipLiqDLog = "" ;
      AV53Pgmname = "retencion_ganancias" ;
      /* GeneXus formulas. */
      AV53Pgmname = "retencion_ganancias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqDCalculado ;
   private byte AV14alcanzaLiqDCalculado ;
   private byte AV41auxLiqDCalculado ;
   private byte AV21importeARetenerLiqDCalculado ;
   private byte AV25sueldoBrutoLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV12LiqNro ;
   private int AV50LiqRelNro ;
   private int AV11LegNumero ;
   private java.math.BigDecimal AV22Importes ;
   private java.math.BigDecimal AV13alcanzaGananciasLiqDImpCalcu ;
   private java.math.BigDecimal AV40auxLiqDImpCalcu ;
   private java.math.BigDecimal AV43netoImportes ;
   private java.math.BigDecimal AV47descuentosImportes ;
   private java.math.BigDecimal AV20importeARetenerLiqDImpCalcu ;
   private java.math.BigDecimal AV24sueldoBrutoLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal AV26sueldo35PorCiento ;
   private String AV49ConCodigo ;
   private String AV35ProcesoLiquidacion ;
   private String AV9alcanzaGananciasConConcodigo ;
   private String AV18esAgente ;
   private String AV39auxConCodigo ;
   private String AV48devGanConCodigo ;
   private String AV53Pgmname ;
   private String AV19importeARetenerConConcodigo ;
   private String AV23sueldoBrutoConConcodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV38LiqPeriodo ;
   private boolean AV36insertandoConceptos ;
   private boolean AV37existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private String AV17LiqDLog ;
   private String AV27formulaAfipLiqDLog ;
   private String AV15error ;
   private String AV34importeARetenerConDescrip ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
   private byte[] aP11 ;
   private GXSimpleCollection<String> AV46excluirConCodigo ;
}

