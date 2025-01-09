package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class previsualizacionnovedad extends GXProcedure
{
   public previsualizacionnovedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( previsualizacionnovedad.class ), "" );
   }

   public previsualizacionnovedad( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.util.Date aP6 ,
                             java.util.Date aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             java.math.BigDecimal[] aP11 )
   {
      previsualizacionnovedad.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.math.BigDecimal aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.util.Date aP6 ,
                        java.util.Date aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.math.BigDecimal aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.util.Date aP6 ,
                             java.util.Date aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             String[] aP12 )
   {
      previsualizacionnovedad.this.AV16clicod = aP0;
      previsualizacionnovedad.this.AV8EmpCod = aP1;
      previsualizacionnovedad.this.AV10LegNumero = aP2;
      previsualizacionnovedad.this.AV11ConCodigo = aP3;
      previsualizacionnovedad.this.AV12AgeCanti = aP4;
      previsualizacionnovedad.this.AV15AgeImporte = aP5;
      previsualizacionnovedad.this.AV27AgeFecDes = aP6;
      previsualizacionnovedad.this.AV29AgeFecHas = aP7;
      previsualizacionnovedad.this.AV30soloCalculo = aP8;
      previsualizacionnovedad.this.aP9 = aP9;
      previsualizacionnovedad.this.aP10 = aP10;
      previsualizacionnovedad.this.aP11 = aP11;
      previsualizacionnovedad.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV33metodoDesglocePalabra ;
      GXt_char2 = AV33metodoDesglocePalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.metododesgloseformula_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      previsualizacionnovedad.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV16clicod, GXt_char2, GXv_char4) ;
      previsualizacionnovedad.this.GXt_char1 = GXv_char4[0] ;
      AV33metodoDesglocePalabra = GXt_char1 ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15AgeImporte)==0) )
      {
         AV9LiqNro = 0 ;
         GXv_char4[0] = AV14ConFormula ;
         new web.getformulaconcepto(remoteHandle, context).execute( AV16clicod, AV11ConCodigo, GXv_char4) ;
         previsualizacionnovedad.this.AV14ConFormula = GXv_char4[0] ;
         if ( ! (GXutil.strcmp("", AV14ConFormula)==0) )
         {
            AV26LiqPeriodo = AV27AgeFecDes ;
            GXv_char4[0] = AV31MENSUALTLiqCod ;
            new web.getparametro(remoteHandle, context).execute( AV16clicod, new web.tipoliqmensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
            previsualizacionnovedad.this.AV31MENSUALTLiqCod = GXv_char4[0] ;
            if ( GXutil.strcmp(AV33metodoDesglocePalabra, httpContext.getMessage( "SDT", "")) == 0 )
            {
               GXv_boolean5[0] = false ;
               GXv_char4[0] = AV18error ;
               GXv_char3[0] = "" ;
               GXv_char6[0] = AV17LiqDFormulaHTML ;
               GXv_char7[0] = "" ;
               GXv_decimal8[0] = AV21Resultado ;
               GXv_boolean9[0] = AV25dependenciasResueltas ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean11[0] = false ;
               GXv_decimal12[0] = AV32defaultAgeCanti ;
               GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean14[0] = AV20soloUnCalculoEs ;
               GXv_char15[0] = AV19LiqDLog ;
               GXv_decimal16[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean17[0] = false ;
               new web.resolverformula(remoteHandle, context).execute( AV16clicod, AV11ConCodigo, AV14ConFormula, AV14ConFormula, AV8EmpCod, AV9LiqNro, 0, AV9LiqNro, AV10LegNumero, AV31MENSUALTLiqCod, AV26LiqPeriodo, AV36Pgmname, "Calculo", true, AV12AgeCanti, AV27AgeFecDes, AV15AgeImporte, DecimalUtil.doubleToDec(0), GXv_boolean5, GXv_char4, GXv_char3, GXv_char6, GXv_char7, GXv_decimal8, GXv_boolean9, GXv_decimal10, GXv_boolean11, GXv_decimal12, GXv_decimal13, GXv_boolean14, GXv_char15, GXv_decimal16, GXv_boolean17) ;
               previsualizacionnovedad.this.AV18error = GXv_char4[0] ;
               previsualizacionnovedad.this.AV17LiqDFormulaHTML = GXv_char6[0] ;
               previsualizacionnovedad.this.AV21Resultado = GXv_decimal8[0] ;
               previsualizacionnovedad.this.AV25dependenciasResueltas = GXv_boolean9[0] ;
               previsualizacionnovedad.this.AV32defaultAgeCanti = GXv_decimal12[0] ;
               previsualizacionnovedad.this.AV20soloUnCalculoEs = GXv_boolean14[0] ;
               previsualizacionnovedad.this.AV19LiqDLog = GXv_char15[0] ;
            }
            else
            {
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "default canti ", "")+GXutil.trim( GXutil.str( AV32defaultAgeCanti, 9, 2))) ;
            if ( AV25dependenciasResueltas )
            {
               GXv_decimal16[0] = AV21Resultado ;
               GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean17[0] = AV24multiplico ;
               GXv_char15[0] = "" ;
               new web.calculomultiporcantimplicito(remoteHandle, context).execute( AV16clicod, AV14ConFormula, (byte)(1), AV12AgeCanti, AV15AgeImporte, GXv_decimal16, GXv_decimal13, GXv_boolean17, GXv_char15) ;
               previsualizacionnovedad.this.AV21Resultado = GXv_decimal16[0] ;
               previsualizacionnovedad.this.AV24multiplico = GXv_boolean17[0] ;
               if ( ! AV30soloCalculo )
               {
                  AV23htmlResultado = httpContext.getMessage( "<b>", "") + GXutil.trim( GXutil.str( AV21Resultado, 14, 2)) + httpContext.getMessage( "</b>", "") ;
               }
               else
               {
                  AV23htmlResultado = GXutil.trim( GXutil.str( AV21Resultado, 14, 2)) ;
               }
            }
            if ( ( AV20soloUnCalculoEs ) && ! (GXutil.strcmp("", AV19LiqDLog)==0) )
            {
               AV23htmlResultado += " (" + GXutil.trim( AV19LiqDLog) + ")" ;
            }
            else
            {
               AV23htmlResultado += " (" + GXutil.trim( AV17LiqDFormulaHTML) ;
               if ( ( AV12AgeCanti.doubleValue() != 1 ) && ( AV24multiplico ) )
               {
                  AV23htmlResultado += " * " + GXutil.trim( GXutil.str( AV12AgeCanti, 9, 2)) ;
               }
               AV23htmlResultado += ")" ;
            }
         }
         else
         {
            AV32defaultAgeCanti = DecimalUtil.doubleToDec(1) ;
         }
      }
      else
      {
         AV23htmlResultado = httpContext.getMessage( "<b>", "") + GXutil.trim( GXutil.str( AV15AgeImporte, 14, 2)) + httpContext.getMessage( "</b> <i> (valor fijo)</i>", "") ;
         AV21Resultado = AV15AgeImporte ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = previsualizacionnovedad.this.AV32defaultAgeCanti;
      this.aP10[0] = previsualizacionnovedad.this.AV18error;
      this.aP11[0] = previsualizacionnovedad.this.AV21Resultado;
      this.aP12[0] = previsualizacionnovedad.this.AV23htmlResultado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32defaultAgeCanti = DecimalUtil.ZERO ;
      AV18error = "" ;
      AV21Resultado = DecimalUtil.ZERO ;
      AV23htmlResultado = "" ;
      AV33metodoDesglocePalabra = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      AV14ConFormula = "" ;
      AV26LiqPeriodo = GXutil.nullDate() ;
      AV31MENSUALTLiqCod = "" ;
      AV36Pgmname = "" ;
      GXv_boolean5 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV17LiqDFormulaHTML = "" ;
      GXv_char6 = new String[1] ;
      GXv_char7 = new String[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_boolean14 = new boolean[1] ;
      AV19LiqDLog = "" ;
      GXv_decimal16 = new java.math.BigDecimal[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_boolean17 = new boolean[1] ;
      GXv_char15 = new String[1] ;
      AV36Pgmname = "PrevisualizacionNovedad" ;
      /* GeneXus formulas. */
      AV36Pgmname = "PrevisualizacionNovedad" ;
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short Gx_err ;
   private int AV16clicod ;
   private int AV10LegNumero ;
   private int AV9LiqNro ;
   private java.math.BigDecimal AV12AgeCanti ;
   private java.math.BigDecimal AV15AgeImporte ;
   private java.math.BigDecimal AV32defaultAgeCanti ;
   private java.math.BigDecimal AV21Resultado ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal GXv_decimal16[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private String AV11ConCodigo ;
   private String AV33metodoDesglocePalabra ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String AV31MENSUALTLiqCod ;
   private String AV36Pgmname ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String GXv_char15[] ;
   private java.util.Date AV27AgeFecDes ;
   private java.util.Date AV29AgeFecHas ;
   private java.util.Date AV26LiqPeriodo ;
   private boolean AV30soloCalculo ;
   private boolean GXv_boolean5[] ;
   private boolean AV25dependenciasResueltas ;
   private boolean GXv_boolean9[] ;
   private boolean GXv_boolean11[] ;
   private boolean AV20soloUnCalculoEs ;
   private boolean GXv_boolean14[] ;
   private boolean AV24multiplico ;
   private boolean GXv_boolean17[] ;
   private String AV23htmlResultado ;
   private String AV14ConFormula ;
   private String AV17LiqDFormulaHTML ;
   private String AV19LiqDLog ;
   private String AV18error ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
}

