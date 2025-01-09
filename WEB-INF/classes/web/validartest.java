package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validartest extends GXProcedure
{
   public validartest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validartest.class ), "" );
   }

   public validartest( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              GXSimpleCollection<Short> aP4 ,
                              String aP5 )
   {
      validartest.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        GXSimpleCollection<Short> aP4 ,
                        String aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             GXSimpleCollection<Short> aP4 ,
                             String aP5 ,
                             boolean[] aP6 )
   {
      validartest.this.AV8CliCod = aP0;
      validartest.this.AV9EmpCod = aP1;
      validartest.this.AV15Leg1_LegNumero = aP2;
      validartest.this.AV16Leg2_LegNumero = aP3;
      validartest.this.AV14TestNro = aP4;
      validartest.this.AV33comparar = aP5;
      validartest.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV35LegNumero = AV15Leg1_LegNumero ;
      /* Execute user subroutine: 'VALIDAR ESTADO' */
      S131 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV35LegNumero = AV16Leg2_LegNumero ;
      /* Execute user subroutine: 'VALIDAR ESTADO' */
      S131 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXv_decimal1[0] = AV11Leg1_LiqImpNeto ;
      GXv_decimal2[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
      GXv_int5[0] = (short)(0) ;
      GXv_int6[0] = (short)(0) ;
      GXv_int7[0] = (short)(0) ;
      GXv_decimal8[0] = AV32Leg1_LiqLegImpTotRetGan ;
      new web.getdatosliqlegtest(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, AV15Leg1_LegNumero, ((Number) AV14TestNro.elementAt(-1+1)).shortValue(), GXv_decimal1, GXv_decimal2, GXv_decimal3, GXv_decimal4, GXv_int5, GXv_int6, GXv_int7, GXv_decimal8) ;
      validartest.this.AV11Leg1_LiqImpNeto = GXv_decimal1[0] ;
      validartest.this.AV32Leg1_LiqLegImpTotRetGan = GXv_decimal8[0] ;
      GXv_decimal8[0] = AV12Leg2_LiqImpNeto ;
      GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal2[0] = DecimalUtil.doubleToDec(0) ;
      GXv_int7[0] = (short)(0) ;
      GXv_int6[0] = (short)(0) ;
      GXv_int5[0] = (short)(0) ;
      GXv_decimal1[0] = AV31Leg2_LiqLegImpTotRetGan ;
      new web.getdatosliqlegtest(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, AV16Leg2_LegNumero, ((Number) AV14TestNro.elementAt(-1+2)).shortValue(), GXv_decimal8, GXv_decimal4, GXv_decimal3, GXv_decimal2, GXv_int7, GXv_int6, GXv_int5, GXv_decimal1) ;
      validartest.this.AV12Leg2_LiqImpNeto = GXv_decimal8[0] ;
      validartest.this.AV31Leg2_LiqLegImpTotRetGan = GXv_decimal1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&Leg2_LiqImpNeto ", "")+GXutil.trim( GXutil.str( AV12Leg2_LiqImpNeto, 14, 2))) ;
      if ( GXutil.strcmp(AV33comparar, httpContext.getMessage( "NETO", "")) == 0 )
      {
         AV18diferencia = AV11Leg1_LiqImpNeto.subtract(AV12Leg2_LiqImpNeto) ;
      }
      else
      {
         AV18diferencia = AV32Leg1_LiqLegImpTotRetGan.subtract(AV31Leg2_LiqLegImpTotRetGan) ;
      }
      if ( AV18diferencia.doubleValue() < 0 )
      {
         AV18diferencia = AV18diferencia.multiply(DecimalUtil.doubleToDec(-1)) ;
      }
      if ( AV18diferencia.doubleValue() <= 100 )
      {
         /* Execute user subroutine: 'OK' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else
      {
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.concepto_sueldobruto_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.concepto_sueldobrutosinsac_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.concepto_sueldobrutogravado_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.remuneraciongravada_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.concepto_deduccionespecialincrementada_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.dedgenmens_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.dedart30_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.ganancianeta_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.gannetsujimp_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.concepto_anticipodesac_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV25conceptosComparar.add(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, GXutil.trim( new web.concepto_descuentosleymasdescsobreanticiposac_codigoparam(remoteHandle, context).executeUdp( ))), 0);
         AV26c = (short)(1) ;
         while ( AV26c <= AV25conceptosComparar.size() )
         {
            GXv_decimal8[0] = AV21LiqDImpCalcu ;
            GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean9[0] = false ;
            GXv_int7[0] = (short)(0) ;
            GXv_int10[0] = (byte)(0) ;
            GXv_boolean11[0] = false ;
            GXv_char12[0] = AV28compararError ;
            new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, 0, AV15Leg1_LegNumero, (String)AV25conceptosComparar.elementAt(-1+AV26c), AV34ConceptoTipo, localUtil.ymdtod( 2023, 1, 1), localUtil.ymdtod( 2023, 12, 1), "", "Calculo", false, false, "", true, "", GXv_decimal8, GXv_decimal4, GXv_boolean9, GXv_int7, GXv_int10, GXv_boolean11, GXv_char12) ;
            validartest.this.AV21LiqDImpCalcu = GXv_decimal8[0] ;
            validartest.this.AV28compararError = GXv_char12[0] ;
            if ( ! (GXutil.strcmp("", AV28compararError)==0) )
            {
               AV24texto.add(AV28compararError, 0);
               if (true) break;
            }
            GXv_decimal8[0] = AV22LiqDImpCalcu2 ;
            GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean11[0] = false ;
            GXv_int7[0] = (short)(0) ;
            GXv_int10[0] = (byte)(0) ;
            GXv_boolean9[0] = false ;
            GXv_char12[0] = AV28compararError ;
            new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, 0, AV16Leg2_LegNumero, (String)AV25conceptosComparar.elementAt(-1+AV26c), AV34ConceptoTipo, localUtil.ymdtod( 2023, 1, 1), localUtil.ymdtod( 2023, 12, 1), "", "Calculo", false, false, "", true, "", GXv_decimal8, GXv_decimal4, GXv_boolean11, GXv_int7, GXv_int10, GXv_boolean9, GXv_char12) ;
            validartest.this.AV22LiqDImpCalcu2 = GXv_decimal8[0] ;
            validartest.this.AV28compararError = GXv_char12[0] ;
            if ( ! (GXutil.strcmp("", AV28compararError)==0) )
            {
               AV24texto.add(AV28compararError, 0);
               if (true) break;
            }
            AV23diferencia2 = AV21LiqDImpCalcu.subtract(AV22LiqDImpCalcu2) ;
            if ( AV23diferencia2.doubleValue() < 0 )
            {
               AV23diferencia2 = AV23diferencia2.multiply(DecimalUtil.doubleToDec(-1)) ;
            }
            if ( AV23diferencia2.doubleValue() > 100 )
            {
               AV24texto.add(httpContext.getMessage( "Diferencia en ", "")+GXutil.trim( (String)AV25conceptosComparar.elementAt(-1+AV26c))+" "+GXutil.trim( GXutil.str( AV23diferencia2, 14, 2)), 0);
            }
            AV26c = (short)(AV26c+1) ;
         }
         /* Execute user subroutine: 'ERROR' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OK' Routine */
      returnInSub = false ;
      AV19TestOK = true ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(A1083TestNro) ,
                                           AV14TestNro } ,
                                           new int[]{
                                           TypeConstants.SHORT
                                           }
      });
      /* Using cursor P016K2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1083TestNro = P016K2_A1083TestNro[0] ;
         A1084TestOK = P016K2_A1084TestOK[0] ;
         A1085TestFechaHora = P016K2_A1085TestFechaHora[0] ;
         A1091TestError = P016K2_A1091TestError[0] ;
         A1092TestNeto = P016K2_A1092TestNeto[0] ;
         A1084TestOK = true ;
         A1085TestFechaHora = GXutil.serverNow( context, remoteHandle, pr_default) ;
         A1091TestError = httpContext.getMessage( "OK prueba ", "") + GXutil.trim( GXutil.str( A1083TestNro, 4, 0)) + " " + GXutil.trim( GXutil.str( AV18diferencia, 12, 1)) ;
         if ( A1083TestNro == 10 )
         {
            A1091TestError += httpContext.getMessage( " (validar bonos prod)", "") ;
         }
         if ( ( AV14TestNro.size() > 0 ) && ( A1083TestNro == ((Number) AV14TestNro.elementAt(-1+1)).shortValue() ) )
         {
            A1092TestNeto = AV11Leg1_LiqImpNeto ;
         }
         else
         {
            if ( ( AV14TestNro.size() > 1 ) && ( A1083TestNro == ((Number) AV14TestNro.elementAt(-1+2)).shortValue() ) )
            {
               A1092TestNeto = AV12Leg2_LiqImpNeto ;
            }
            else
            {
               A1092TestNeto = DecimalUtil.ZERO ;
            }
         }
         /* Using cursor P016K3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(A1084TestOK), A1085TestFechaHora, A1091TestError, A1092TestNeto, Short.valueOf(A1083TestNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Test");
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S121( )
   {
      /* 'ERROR' Routine */
      returnInSub = false ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           Short.valueOf(A1083TestNro) ,
                                           AV14TestNro } ,
                                           new int[]{
                                           TypeConstants.SHORT
                                           }
      });
      /* Using cursor P016K4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1083TestNro = P016K4_A1083TestNro[0] ;
         A1084TestOK = P016K4_A1084TestOK[0] ;
         A1085TestFechaHora = P016K4_A1085TestFechaHora[0] ;
         A1091TestError = P016K4_A1091TestError[0] ;
         A1092TestNeto = P016K4_A1092TestNeto[0] ;
         A1084TestOK = false ;
         A1085TestFechaHora = GXutil.serverNow( context, remoteHandle, pr_default) ;
         A1091TestError = httpContext.getMessage( "Error prueba ", "") + GXutil.trim( GXutil.str( A1083TestNro, 4, 0)) + httpContext.getMessage( ". Diferencia ", "") + GXutil.trim( GXutil.str( AV18diferencia, 12, 1)) + httpContext.getMessage( " &Leg1_LiqImpNeto ", "") + GXutil.trim( GXutil.str( AV11Leg1_LiqImpNeto, 14, 2)) + httpContext.getMessage( " &Leg2_LiqImpNeto ", "") + GXutil.trim( GXutil.str( AV12Leg2_LiqImpNeto, 14, 2)) ;
         AV29i = (short)(1) ;
         while ( AV29i <= AV24texto.size() )
         {
            A1091TestError += " (" + GXutil.trim( (String)AV24texto.elementAt(-1+AV29i)) + ")" ;
            AV29i = (short)(AV29i+1) ;
         }
         if ( ( AV14TestNro.size() > 0 ) && ( A1083TestNro == ((Number) AV14TestNro.elementAt(-1+1)).shortValue() ) )
         {
            A1092TestNeto = AV11Leg1_LiqImpNeto ;
         }
         else
         {
            if ( ( AV14TestNro.size() > 1 ) && ( A1083TestNro == ((Number) AV14TestNro.elementAt(-1+2)).shortValue() ) )
            {
               A1092TestNeto = AV12Leg2_LiqImpNeto ;
            }
            else
            {
               A1092TestNeto = DecimalUtil.ZERO ;
            }
         }
         /* Using cursor P016K5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(A1084TestOK), A1085TestFechaHora, A1091TestError, A1092TestNeto, Short.valueOf(A1083TestNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Test");
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void S131( )
   {
      /* 'VALIDAR ESTADO' Routine */
      returnInSub = false ;
      /* Using cursor P016K6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV35LegNumero)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A31LiqNro = P016K6_A31LiqNro[0] ;
         A278LiqEstado = P016K6_A278LiqEstado[0] ;
         A6LegNumero = P016K6_A6LegNumero[0] ;
         A1EmpCod = P016K6_A1EmpCod[0] ;
         A3CliCod = P016K6_A3CliCod[0] ;
         A278LiqEstado = P016K6_A278LiqEstado[0] ;
         pr_default.dynParam(5, new Object[]{ new Object[]{
                                              Short.valueOf(A1083TestNro) ,
                                              AV14TestNro } ,
                                              new int[]{
                                              TypeConstants.SHORT
                                              }
         });
         /* Using cursor P016K7 */
         pr_default.execute(5);
         while ( (pr_default.getStatus(5) != 101) )
         {
            A1083TestNro = P016K7_A1083TestNro[0] ;
            A1091TestError = P016K7_A1091TestError[0] ;
            A1091TestError = httpContext.getMessage( "Liquidación con estado de error", "") ;
            /* Using cursor P016K8 */
            pr_default.execute(6, new Object[] {A1091TestError, Short.valueOf(A1083TestNro)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Test");
            pr_default.readNext(5);
         }
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(4);
         returnInSub = true;
         if (true) return;
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   protected void cleanup( )
   {
      this.aP6[0] = validartest.this.AV19TestOK;
      Application.commitDataStores(context, remoteHandle, pr_default, "validartest");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Leg1_LiqImpNeto = DecimalUtil.ZERO ;
      AV32Leg1_LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV12Leg2_LiqImpNeto = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_int6 = new short[1] ;
      GXv_int5 = new short[1] ;
      AV31Leg2_LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV38Pgmname = "" ;
      AV18diferencia = DecimalUtil.ZERO ;
      AV25conceptosComparar = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34ConceptoTipo = "" ;
      AV21LiqDImpCalcu = DecimalUtil.ZERO ;
      AV28compararError = "" ;
      AV24texto = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22LiqDImpCalcu2 = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_int7 = new short[1] ;
      GXv_int10 = new byte[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_char12 = new String[1] ;
      AV23diferencia2 = DecimalUtil.ZERO ;
      A1092TestNeto = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P016K2_A1083TestNro = new short[1] ;
      P016K2_A1084TestOK = new boolean[] {false} ;
      P016K2_A1085TestFechaHora = new java.util.Date[] {GXutil.nullDate()} ;
      P016K2_A1091TestError = new String[] {""} ;
      P016K2_A1092TestNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1085TestFechaHora = GXutil.resetTime( GXutil.nullDate() );
      A1091TestError = "" ;
      P016K4_A1083TestNro = new short[1] ;
      P016K4_A1084TestOK = new boolean[] {false} ;
      P016K4_A1085TestFechaHora = new java.util.Date[] {GXutil.nullDate()} ;
      P016K4_A1091TestError = new String[] {""} ;
      P016K4_A1092TestNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P016K6_A31LiqNro = new int[1] ;
      P016K6_A278LiqEstado = new byte[1] ;
      P016K6_A6LegNumero = new int[1] ;
      P016K6_A1EmpCod = new short[1] ;
      P016K6_A3CliCod = new int[1] ;
      P016K7_A1083TestNro = new short[1] ;
      P016K7_A1091TestError = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validartest__default(),
         new Object[] {
             new Object[] {
            P016K2_A1083TestNro, P016K2_A1084TestOK, P016K2_A1085TestFechaHora, P016K2_A1091TestError, P016K2_A1092TestNeto
            }
            , new Object[] {
            }
            , new Object[] {
            P016K4_A1083TestNro, P016K4_A1084TestOK, P016K4_A1085TestFechaHora, P016K4_A1091TestError, P016K4_A1092TestNeto
            }
            , new Object[] {
            }
            , new Object[] {
            P016K6_A31LiqNro, P016K6_A278LiqEstado, P016K6_A6LegNumero, P016K6_A1EmpCod, P016K6_A3CliCod
            }
            , new Object[] {
            P016K7_A1083TestNro, P016K7_A1091TestError
            }
            , new Object[] {
            }
         }
      );
      AV38Pgmname = "validarTest" ;
      /* GeneXus formulas. */
      AV38Pgmname = "validarTest" ;
      Gx_err = (short)(0) ;
   }

   private byte GXv_int10[] ;
   private byte A278LiqEstado ;
   private short AV9EmpCod ;
   private short GXv_int6[] ;
   private short GXv_int5[] ;
   private short AV26c ;
   private short GXv_int7[] ;
   private short A1083TestNro ;
   private short AV29i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15Leg1_LegNumero ;
   private int AV16Leg2_LegNumero ;
   private int AV35LegNumero ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV11Leg1_LiqImpNeto ;
   private java.math.BigDecimal AV32Leg1_LiqLegImpTotRetGan ;
   private java.math.BigDecimal AV12Leg2_LiqImpNeto ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal AV31Leg2_LiqLegImpTotRetGan ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal AV18diferencia ;
   private java.math.BigDecimal AV21LiqDImpCalcu ;
   private java.math.BigDecimal AV22LiqDImpCalcu2 ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal AV23diferencia2 ;
   private java.math.BigDecimal A1092TestNeto ;
   private String AV33comparar ;
   private String AV38Pgmname ;
   private String AV34ConceptoTipo ;
   private String GXv_char12[] ;
   private String scmdbuf ;
   private java.util.Date A1085TestFechaHora ;
   private boolean AV19TestOK ;
   private boolean returnInSub ;
   private boolean GXv_boolean11[] ;
   private boolean GXv_boolean9[] ;
   private boolean A1084TestOK ;
   private String AV28compararError ;
   private String A1091TestError ;
   private GXSimpleCollection<Short> AV14TestNro ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private short[] P016K2_A1083TestNro ;
   private boolean[] P016K2_A1084TestOK ;
   private java.util.Date[] P016K2_A1085TestFechaHora ;
   private String[] P016K2_A1091TestError ;
   private java.math.BigDecimal[] P016K2_A1092TestNeto ;
   private short[] P016K4_A1083TestNro ;
   private boolean[] P016K4_A1084TestOK ;
   private java.util.Date[] P016K4_A1085TestFechaHora ;
   private String[] P016K4_A1091TestError ;
   private java.math.BigDecimal[] P016K4_A1092TestNeto ;
   private int[] P016K6_A31LiqNro ;
   private byte[] P016K6_A278LiqEstado ;
   private int[] P016K6_A6LegNumero ;
   private short[] P016K6_A1EmpCod ;
   private int[] P016K6_A3CliCod ;
   private short[] P016K7_A1083TestNro ;
   private String[] P016K7_A1091TestError ;
   private GXSimpleCollection<String> AV25conceptosComparar ;
   private GXSimpleCollection<String> AV24texto ;
}

final  class validartest__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P016K2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A1083TestNro ,
                                          GXSimpleCollection<Short> AV14TestNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT TestNro, TestOK, TestFechaHora, TestError, TestNeto FROM Test" ;
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV14TestNro, "TestNro IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TestNro" ;
      scmdbuf += " FOR UPDATE OF Test" ;
      GXv_Object13[0] = scmdbuf ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P016K4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A1083TestNro ,
                                          GXSimpleCollection<Short> AV14TestNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT TestNro, TestOK, TestFechaHora, TestError, TestNeto FROM Test" ;
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV14TestNro, "TestNro IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TestNro" ;
      scmdbuf += " FOR UPDATE OF Test" ;
      GXv_Object16[0] = scmdbuf ;
      return GXv_Object16 ;
   }

   protected Object[] conditional_P016K7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A1083TestNro ,
                                          GXSimpleCollection<Short> AV14TestNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT TestNro, TestError FROM Test" ;
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV14TestNro, "TestNro IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TestNro" ;
      scmdbuf += " FOR UPDATE OF Test" ;
      GXv_Object19[0] = scmdbuf ;
      return GXv_Object19 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P016K2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] );
            case 2 :
                  return conditional_P016K4(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] );
            case 5 :
                  return conditional_P016K7(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P016K2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P016K3", "SAVEPOINT gxupdate;UPDATE Test SET TestOK=?, TestFechaHora=?, TestError=?, TestNeto=?  WHERE TestNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P016K4", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P016K5", "SAVEPOINT gxupdate;UPDATE Test SET TestOK=?, TestFechaHora=?, TestError=?, TestNeto=?  WHERE TestNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P016K6", "SELECT T1.LiqNro, T2.LiqEstado, T1.LegNumero, T1.EmpCod, T1.CliCod FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T2.LiqEstado = 2) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P016K7", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P016K8", "SAVEPOINT gxupdate;UPDATE Test SET TestError=?  WHERE TestNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 1 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 3 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

