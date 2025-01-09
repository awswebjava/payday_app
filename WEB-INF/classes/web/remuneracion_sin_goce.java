package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class remuneracion_sin_goce extends GXProcedure
{
   public remuneracion_sin_goce( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( remuneracion_sin_goce.class ), "" );
   }

   public remuneracion_sin_goce( int remoteHandle ,
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
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.util.Date aP9 ,
                             java.util.Date aP10 ,
                             String aP11 ,
                             byte aP12 ,
                             String aP13 ,
                             String aP14 ,
                             boolean aP15 ,
                             boolean aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             String[] aP19 ,
                             byte[] aP20 )
   {
      remuneracion_sin_goce.this.aP21 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
      return aP21[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.util.Date aP9 ,
                        java.util.Date aP10 ,
                        String aP11 ,
                        byte aP12 ,
                        String aP13 ,
                        String aP14 ,
                        boolean aP15 ,
                        boolean aP16 ,
                        java.math.BigDecimal[] aP17 ,
                        java.math.BigDecimal[] aP18 ,
                        String[] aP19 ,
                        byte[] aP20 ,
                        String[] aP21 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.util.Date aP9 ,
                             java.util.Date aP10 ,
                             String aP11 ,
                             byte aP12 ,
                             String aP13 ,
                             String aP14 ,
                             boolean aP15 ,
                             boolean aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             String[] aP19 ,
                             byte[] aP20 ,
                             String[] aP21 )
   {
      remuneracion_sin_goce.this.AV8CliCod = aP0;
      remuneracion_sin_goce.this.AV9EmpCod = aP1;
      remuneracion_sin_goce.this.AV10LiqNro = aP2;
      remuneracion_sin_goce.this.AV35LiqRelNro = aP3;
      remuneracion_sin_goce.this.AV13LegNumero = aP4;
      remuneracion_sin_goce.this.AV28ConCodigo = aP5;
      remuneracion_sin_goce.this.AV36DConCondicion = aP6;
      remuneracion_sin_goce.this.AV32operandos = aP7;
      remuneracion_sin_goce.this.AV30parmLiqDCanti = aP8;
      remuneracion_sin_goce.this.AV12LiqPeriodo = aP9;
      remuneracion_sin_goce.this.AV33fecha = aP10;
      remuneracion_sin_goce.this.AV17TLiqCod = aP11;
      remuneracion_sin_goce.this.AV16LegClase = aP12;
      remuneracion_sin_goce.this.AV24ProcesoLiquidacion = aP13;
      remuneracion_sin_goce.this.AV34llamador = aP14;
      remuneracion_sin_goce.this.AV23insertandoConceptos = aP15;
      remuneracion_sin_goce.this.AV39vacacionesEs = aP16;
      remuneracion_sin_goce.this.aP17 = aP17;
      remuneracion_sin_goce.this.aP18 = aP18;
      remuneracion_sin_goce.this.aP19 = aP19;
      remuneracion_sin_goce.this.aP20 = aP20;
      remuneracion_sin_goce.this.aP21 = aP21;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV26LiqDCalculado = (byte)(1) ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30parmLiqDCanti)==0) )
      {
         if ( GXutil.strcmp(AV36DConCondicion, "MI") == 0 )
         {
            GXv_date1[0] = AV41LegFecIngreso ;
            GXv_date2[0] = AV42LegFecEgreso ;
            new web.getfecingresoyegreso(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV13LegNumero, GXv_date1, GXv_date2) ;
            remuneracion_sin_goce.this.AV41LegFecIngreso = GXv_date1[0] ;
            remuneracion_sin_goce.this.AV42LegFecEgreso = GXv_date2[0] ;
            if ( GXutil.resetTime(AV41LegFecIngreso).after( GXutil.resetTime( AV12LiqPeriodo )) && (( GXutil.resetTime(AV41LegFecIngreso).before( GXutil.resetTime( GXutil.eomdate( AV12LiqPeriodo) )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV41LegFecIngreso), GXutil.resetTime(GXutil.eomdate( AV12LiqPeriodo))) )) )
            {
               AV11LiqDCanti = DecimalUtil.doubleToDec(GXutil.day( AV41LegFecIngreso)) ;
               AV11LiqDCanti = AV11LiqDCanti.subtract(DecimalUtil.doubleToDec(1)) ;
               AV25LiqDLog = httpContext.getMessage( "Inicializa ", "") + GXutil.trim( GXutil.str( AV11LiqDCanti, 14, 2)) + httpContext.getMessage( " días no trabajados por ser la fecha de ingreso el ", "") + GXutil.trim( localUtil.dtoc( AV41LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
            }
            if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42LegFecEgreso)) && GXutil.resetTime(AV42LegFecEgreso).before( GXutil.resetTime( GXutil.eomdate( AV42LegFecEgreso) )) )
            {
               AV43auxLiqDCanti = DecimalUtil.doubleToDec(GXutil.day( GXutil.eomdate( AV42LegFecEgreso))-GXutil.day( AV42LegFecEgreso)) ;
               if ( ! (GXutil.strcmp("", AV25LiqDLog)==0) )
               {
                  AV11LiqDCanti = AV11LiqDCanti.add(AV43auxLiqDCanti) ;
                  AV25LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV43auxLiqDCanti, 14, 2)) + httpContext.getMessage( " días no trabajados por ser la fecha de egreso ", "") + GXutil.trim( localUtil.dtoc( AV42LegFecEgreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " menor al último día del mes", "") ;
               }
               else
               {
                  AV11LiqDCanti = AV43auxLiqDCanti ;
                  AV25LiqDLog = httpContext.getMessage( "Inicializa ", "") + GXutil.trim( GXutil.str( AV11LiqDCanti, 14, 2)) + httpContext.getMessage( " días no trabajados por ser la fecha de egreso ", "") + GXutil.trim( localUtil.dtoc( AV42LegFecEgreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " menor al último día del mes", "") ;
               }
            }
         }
         else
         {
            GXv_date2[0] = AV15iniPeriodo ;
            GXv_date1[0] = AV14finPeriodo ;
            new web.getrangoperiodos(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV13LegNumero, AV17TLiqCod, AV16LegClase, AV12LiqPeriodo, false, GXv_date2, GXv_date1) ;
            remuneracion_sin_goce.this.AV15iniPeriodo = GXv_date2[0] ;
            remuneracion_sin_goce.this.AV14finPeriodo = GXv_date1[0] ;
            if ( GXutil.strcmp(AV36DConCondicion, "AI") == 0 )
            {
               GXt_char3 = AV29ConCondCodigo ;
               GXv_char4[0] = GXt_char3 ;
               new web.estadoausenciasinjustificadas(remoteHandle, context).execute( AV8CliCod, GXv_char4) ;
               remuneracion_sin_goce.this.GXt_char3 = GXv_char4[0] ;
               AV29ConCondCodigo = GXt_char3 ;
            }
            else
            {
               GXv_char4[0] = AV29ConCondCodigo ;
               new web.getcondicioncodigo(remoteHandle, context).execute( AV8CliCod, AV28ConCodigo, GXv_char4) ;
               remuneracion_sin_goce.this.AV29ConCondCodigo = GXv_char4[0] ;
            }
            GXv_char4[0] = "" ;
            GXv_int5[0] = (short)(DecimalUtil.decToDouble(AV11LiqDCanti)) ;
            GXv_date2[0] = AV18date ;
            GXv_date1[0] = AV18date ;
            GXv_date6[0] = AV18date ;
            GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean8[0] = false ;
            GXv_char9[0] = AV20auxLiqDLog ;
            new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV13LegNumero, AV10LiqNro, false, AV15iniPeriodo, false, AV14finPeriodo, AV29ConCondCodigo, false, false, false, GXv_char4, GXv_int5, GXv_date2, GXv_date1, GXv_date6, GXv_decimal7, GXv_boolean8, GXv_char9) ;
            remuneracion_sin_goce.this.AV11LiqDCanti = DecimalUtil.doubleToDec(GXv_int5[0]) ;
            remuneracion_sin_goce.this.AV18date = GXv_date2[0] ;
            remuneracion_sin_goce.this.AV18date = GXv_date1[0] ;
            remuneracion_sin_goce.this.AV18date = GXv_date6[0] ;
            remuneracion_sin_goce.this.AV20auxLiqDLog = GXv_char9[0] ;
            AV25LiqDLog = AV20auxLiqDLog ;
         }
      }
      else
      {
         AV11LiqDCanti = AV30parmLiqDCanti ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&LiqDCanti ", "")+GXutil.trim( GXutil.str( AV11LiqDCanti, 14, 2))) ;
      if ( AV11LiqDCanti.doubleValue() == 0 )
      {
         if ( GXutil.strcmp(AV36DConCondicion, "MI") == 0 )
         {
            AV25LiqDLog = httpContext.getMessage( "No hay días de ausencias por mes parcial", "") ;
         }
         else
         {
            AV25LiqDLog = httpContext.getMessage( "No hay días de licencias sin goce de sueldo o ausencias injustificadas", "") ;
         }
      }
      else
      {
         if ( GXutil.strcmp(AV36DConCondicion, "MI") == 0 )
         {
            GXv_decimal7[0] = AV19Importes ;
            GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
            GXv_int11[0] = AV21auxLiqDCalculado ;
            GXv_char9[0] = AV22auxError ;
            GXv_char4[0] = AV20auxLiqDLog ;
            GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
            GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
            new web.remuneracionlicencia5(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV35LiqRelNro, AV13LegNumero, AV33fecha, AV32operandos, AV28ConCodigo, AV11LiqDCanti, AV12LiqPeriodo, true, AV24ProcesoLiquidacion, AV34llamador, AV23insertandoConceptos, GXv_decimal7, GXv_decimal10, GXv_int11, GXv_char9, GXv_char4, GXv_decimal12, GXv_decimal13) ;
            remuneracion_sin_goce.this.AV19Importes = GXv_decimal7[0] ;
            remuneracion_sin_goce.this.AV21auxLiqDCalculado = GXv_int11[0] ;
            remuneracion_sin_goce.this.AV22auxError = GXv_char9[0] ;
            remuneracion_sin_goce.this.AV20auxLiqDLog = GXv_char4[0] ;
            if ( AV21auxLiqDCalculado == 0 )
            {
               AV26LiqDCalculado = (byte)(0) ;
               AV27error = AV22auxError ;
               AV25LiqDLog = AV27error ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV25LiqDLog += ". " + GXutil.trim( AV20auxLiqDLog) ;
         }
         else
         {
            GXt_char3 = AV38vacConCodigo ;
            GXt_char14 = AV38vacConCodigo ;
            GXv_char9[0] = GXt_char14 ;
            new web.concepto_vacacioneslibres_codigoparam(remoteHandle, context).execute( GXv_char9) ;
            remuneracion_sin_goce.this.GXt_char14 = GXv_char9[0] ;
            GXv_char4[0] = GXt_char3 ;
            new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char14, GXv_char4) ;
            remuneracion_sin_goce.this.GXt_char3 = GXv_char4[0] ;
            AV38vacConCodigo = GXt_char3 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&LiqNro: ", "")+GXutil.trim( GXutil.str( AV10LiqNro, 8, 0))) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&&LegNumero: ", "")+GXutil.trim( GXutil.str( AV13LegNumero, 8, 0))) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&&DConCondicion: ", "")+GXutil.trim( AV36DConCondicion)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&vacConCodigo: ", "")+GXutil.trim( AV38vacConCodigo)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&vacacionesEs: ", "")+GXutil.trim( GXutil.booltostr( AV39vacacionesEs))) ;
            AV47GXLvl74 = (byte)(0) ;
            pr_default.dynParam(0, new Object[]{ new Object[]{
                                                 Boolean.valueOf(AV39vacacionesEs) ,
                                                 A394DConCodigo ,
                                                 AV38vacConCodigo ,
                                                 A1487DConCondicion ,
                                                 AV36DConCondicion ,
                                                 Integer.valueOf(AV8CliCod) ,
                                                 Short.valueOf(AV9EmpCod) ,
                                                 Integer.valueOf(AV10LiqNro) ,
                                                 Integer.valueOf(AV13LegNumero) ,
                                                 Integer.valueOf(A3CliCod) ,
                                                 Short.valueOf(A1EmpCod) ,
                                                 Integer.valueOf(A31LiqNro) ,
                                                 Integer.valueOf(A6LegNumero) } ,
                                                 new int[]{
                                                 TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                                 TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                                 }
            });
            /* Using cursor P01BJ2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV13LegNumero), AV36DConCondicion, AV38vacConCodigo, AV38vacConCodigo});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A394DConCodigo = P01BJ2_A394DConCodigo[0] ;
               A6LegNumero = P01BJ2_A6LegNumero[0] ;
               A1487DConCondicion = P01BJ2_A1487DConCondicion[0] ;
               A31LiqNro = P01BJ2_A31LiqNro[0] ;
               A1EmpCod = P01BJ2_A1EmpCod[0] ;
               A3CliCod = P01BJ2_A3CliCod[0] ;
               A507LiqDCalculado = P01BJ2_A507LiqDCalculado[0] ;
               A763LiqDRecalculado = P01BJ2_A763LiqDRecalculado[0] ;
               A393DConDescrip = P01BJ2_A393DConDescrip[0] ;
               A269LiqDCanti = P01BJ2_A269LiqDCanti[0] ;
               n269LiqDCanti = P01BJ2_n269LiqDCanti[0] ;
               A81LiqDSecuencial = P01BJ2_A81LiqDSecuencial[0] ;
               AV47GXLvl74 = (byte)(1) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV28ConCodigo)) ;
               if ( GXutil.strcmp(GXutil.trim( A394DConCodigo), GXutil.trim( AV28ConCodigo)) != 0 )
               {
                  GXv_int11[0] = AV21auxLiqDCalculado ;
                  new web.dependenciaresuelta2(remoteHandle, context).execute( AV8CliCod, A394DConCodigo, AV24ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int11) ;
                  remuneracion_sin_goce.this.AV21auxLiqDCalculado = GXv_int11[0] ;
                  if ( AV21auxLiqDCalculado == 0 )
                  {
                     AV26LiqDCalculado = (byte)(0) ;
                     AV27error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
                     AV25LiqDLog = AV27error ;
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, "2") ;
               GXv_decimal13[0] = AV37auxImportes ;
               GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
               GXv_int11[0] = AV21auxLiqDCalculado ;
               GXv_char9[0] = AV22auxError ;
               GXv_char4[0] = AV20auxLiqDLog ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
               new web.remuneracionlicencia5(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV35LiqRelNro, AV13LegNumero, AV33fecha, AV32operandos, A394DConCodigo, A269LiqDCanti, AV12LiqPeriodo, true, AV24ProcesoLiquidacion, AV34llamador, AV23insertandoConceptos, GXv_decimal13, GXv_decimal12, GXv_int11, GXv_char9, GXv_char4, GXv_decimal10, GXv_decimal7) ;
               remuneracion_sin_goce.this.AV37auxImportes = GXv_decimal13[0] ;
               remuneracion_sin_goce.this.AV21auxLiqDCalculado = GXv_int11[0] ;
               remuneracion_sin_goce.this.AV22auxError = GXv_char9[0] ;
               remuneracion_sin_goce.this.AV20auxLiqDLog = GXv_char4[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, "3") ;
               if ( AV21auxLiqDCalculado == 0 )
               {
                  AV26LiqDCalculado = (byte)(0) ;
                  AV27error = AV22auxError ;
                  AV25LiqDLog = AV27error ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, "4") ;
               AV19Importes = AV19Importes.add(AV37auxImportes) ;
               AV25LiqDLog += GXutil.trim( GXutil.str( AV37auxImportes, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) + " (" + GXutil.trim( AV20auxLiqDLog) + ")" ;
               pr_default.readNext(0);
            }
            pr_default.close(0);
            if ( AV47GXLvl74 == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "none", "")) ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP17[0] = remuneracion_sin_goce.this.AV19Importes;
      this.aP18[0] = remuneracion_sin_goce.this.AV11LiqDCanti;
      this.aP19[0] = remuneracion_sin_goce.this.AV27error;
      this.aP20[0] = remuneracion_sin_goce.this.AV26LiqDCalculado;
      this.aP21[0] = remuneracion_sin_goce.this.AV25LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Importes = DecimalUtil.ZERO ;
      AV11LiqDCanti = DecimalUtil.ZERO ;
      AV27error = "" ;
      AV25LiqDLog = "" ;
      AV41LegFecIngreso = GXutil.nullDate() ;
      AV42LegFecEgreso = GXutil.nullDate() ;
      AV43auxLiqDCanti = DecimalUtil.ZERO ;
      AV15iniPeriodo = GXutil.nullDate() ;
      AV14finPeriodo = GXutil.nullDate() ;
      AV29ConCondCodigo = "" ;
      GXv_int5 = new short[1] ;
      AV18date = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      GXv_date1 = new java.util.Date[1] ;
      GXv_date6 = new java.util.Date[1] ;
      GXv_boolean8 = new boolean[1] ;
      AV20auxLiqDLog = "" ;
      AV46Pgmname = "" ;
      AV22auxError = "" ;
      AV38vacConCodigo = "" ;
      GXt_char3 = "" ;
      GXt_char14 = "" ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A1487DConCondicion = "" ;
      P01BJ2_A394DConCodigo = new String[] {""} ;
      P01BJ2_A6LegNumero = new int[1] ;
      P01BJ2_A1487DConCondicion = new String[] {""} ;
      P01BJ2_A31LiqNro = new int[1] ;
      P01BJ2_A1EmpCod = new short[1] ;
      P01BJ2_A3CliCod = new int[1] ;
      P01BJ2_A507LiqDCalculado = new byte[1] ;
      P01BJ2_A763LiqDRecalculado = new short[1] ;
      P01BJ2_A393DConDescrip = new String[] {""} ;
      P01BJ2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01BJ2_n269LiqDCanti = new boolean[] {false} ;
      P01BJ2_A81LiqDSecuencial = new int[1] ;
      A393DConDescrip = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      AV37auxImportes = DecimalUtil.ZERO ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_int11 = new byte[1] ;
      GXv_char9 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.remuneracion_sin_goce__default(),
         new Object[] {
             new Object[] {
            P01BJ2_A394DConCodigo, P01BJ2_A6LegNumero, P01BJ2_A1487DConCondicion, P01BJ2_A31LiqNro, P01BJ2_A1EmpCod, P01BJ2_A3CliCod, P01BJ2_A507LiqDCalculado, P01BJ2_A763LiqDRecalculado, P01BJ2_A393DConDescrip, P01BJ2_A269LiqDCanti,
            P01BJ2_n269LiqDCanti, P01BJ2_A81LiqDSecuencial
            }
         }
      );
      AV46Pgmname = "remuneracion_sin_goce" ;
      /* GeneXus formulas. */
      AV46Pgmname = "remuneracion_sin_goce" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16LegClase ;
   private byte AV26LiqDCalculado ;
   private byte AV21auxLiqDCalculado ;
   private byte AV47GXLvl74 ;
   private byte A507LiqDCalculado ;
   private byte GXv_int11[] ;
   private short AV9EmpCod ;
   private short GXv_int5[] ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV35LiqRelNro ;
   private int AV13LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV30parmLiqDCanti ;
   private java.math.BigDecimal AV19Importes ;
   private java.math.BigDecimal AV11LiqDCanti ;
   private java.math.BigDecimal AV43auxLiqDCanti ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal AV37auxImportes ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV28ConCodigo ;
   private String AV36DConCondicion ;
   private String AV32operandos ;
   private String AV17TLiqCod ;
   private String AV24ProcesoLiquidacion ;
   private String AV34llamador ;
   private String AV29ConCondCodigo ;
   private String AV46Pgmname ;
   private String AV38vacConCodigo ;
   private String GXt_char3 ;
   private String GXt_char14 ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A1487DConCondicion ;
   private String GXv_char9[] ;
   private String GXv_char4[] ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date AV33fecha ;
   private java.util.Date AV41LegFecIngreso ;
   private java.util.Date AV42LegFecEgreso ;
   private java.util.Date AV15iniPeriodo ;
   private java.util.Date AV14finPeriodo ;
   private java.util.Date AV18date ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date GXv_date6[] ;
   private boolean AV23insertandoConceptos ;
   private boolean AV39vacacionesEs ;
   private boolean GXv_boolean8[] ;
   private boolean returnInSub ;
   private boolean n269LiqDCanti ;
   private String AV25LiqDLog ;
   private String AV20auxLiqDLog ;
   private String AV27error ;
   private String AV22auxError ;
   private String A393DConDescrip ;
   private String[] aP21 ;
   private java.math.BigDecimal[] aP17 ;
   private java.math.BigDecimal[] aP18 ;
   private String[] aP19 ;
   private byte[] aP20 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BJ2_A394DConCodigo ;
   private int[] P01BJ2_A6LegNumero ;
   private String[] P01BJ2_A1487DConCondicion ;
   private int[] P01BJ2_A31LiqNro ;
   private short[] P01BJ2_A1EmpCod ;
   private int[] P01BJ2_A3CliCod ;
   private byte[] P01BJ2_A507LiqDCalculado ;
   private short[] P01BJ2_A763LiqDRecalculado ;
   private String[] P01BJ2_A393DConDescrip ;
   private java.math.BigDecimal[] P01BJ2_A269LiqDCanti ;
   private boolean[] P01BJ2_n269LiqDCanti ;
   private int[] P01BJ2_A81LiqDSecuencial ;
}

final  class remuneracion_sin_goce__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01BJ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV39vacacionesEs ,
                                          String A394DConCodigo ,
                                          String AV38vacConCodigo ,
                                          String A1487DConCondicion ,
                                          String AV36DConCondicion ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LiqNro ,
                                          int AV13LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[7];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT DConCodigo, LegNumero, DConCondicion, LiqNro, EmpCod, CliCod, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDCanti, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "(DConCondicion = ( ?))");
      if ( AV39vacacionesEs )
      {
         addWhere(sWhereString, "(DConCodigo = ( ?))");
      }
      else
      {
         GXv_int15[5] = (byte)(1) ;
      }
      if ( ! AV39vacacionesEs )
      {
         addWhere(sWhereString, "(DConCodigo <> ( ?))");
      }
      else
      {
         GXv_int15[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
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
                  return conditional_P01BJ2(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BJ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(11);
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
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               return;
      }
   }

}

