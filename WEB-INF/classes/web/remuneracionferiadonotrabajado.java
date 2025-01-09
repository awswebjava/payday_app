package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class remuneracionferiadonotrabajado extends GXProcedure
{
   public remuneracionferiadonotrabajado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( remuneracionferiadonotrabajado.class ), "" );
   }

   public remuneracionferiadonotrabajado( int remoteHandle ,
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
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             String[] aP12 ,
                             byte[] aP13 ,
                             java.math.BigDecimal[] aP14 )
   {
      remuneracionferiadonotrabajado.this.aP15 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
      return aP15[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        String[] aP12 ,
                        byte[] aP13 ,
                        java.math.BigDecimal[] aP14 ,
                        String[] aP15 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             String[] aP12 ,
                             byte[] aP13 ,
                             java.math.BigDecimal[] aP14 ,
                             String[] aP15 )
   {
      remuneracionferiadonotrabajado.this.AV12CliCod = aP0;
      remuneracionferiadonotrabajado.this.AV16EmpCod = aP1;
      remuneracionferiadonotrabajado.this.AV17LegNumero = aP2;
      remuneracionferiadonotrabajado.this.AV20LiqNro = aP3;
      remuneracionferiadonotrabajado.this.AV67LiqRelNro = aP4;
      remuneracionferiadonotrabajado.this.AV13LiqPeriodo = aP5;
      remuneracionferiadonotrabajado.this.AV39ConCodigo = aP6;
      remuneracionferiadonotrabajado.this.AV63FerTipo = aP7;
      remuneracionferiadonotrabajado.this.AV31ProcesoLiquidacion = aP8;
      remuneracionferiadonotrabajado.this.AV65llamador = aP9;
      remuneracionferiadonotrabajado.this.AV40insertandoConceptos = aP10;
      remuneracionferiadonotrabajado.this.aP11 = aP11;
      remuneracionferiadonotrabajado.this.aP12 = aP12;
      remuneracionferiadonotrabajado.this.aP13 = aP13;
      remuneracionferiadonotrabajado.this.aP14 = aP14;
      remuneracionferiadonotrabajado.this.aP15 = aP15;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, "1") ;
      AV46LiqDCalculado = (byte)(1) ;
      GXt_int1 = AV11PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getpaicod(remoteHandle, context).execute( AV12CliCod, GXv_int2) ;
      remuneracionferiadonotrabajado.this.GXt_int1 = GXv_int2[0] ;
      AV11PaiCod = GXt_int1 ;
      GXv_char3[0] = AV19TLiqCod ;
      new web.gettipoliq(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV20LiqNro, GXv_char3) ;
      remuneracionferiadonotrabajado.this.AV19TLiqCod = GXv_char3[0] ;
      GXv_int4[0] = AV15LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV17LegNumero, GXv_int4) ;
      remuneracionferiadonotrabajado.this.AV15LegClase = GXv_int4[0] ;
      GXv_date5[0] = AV35desdeFerFecha ;
      GXv_date6[0] = AV36hastaFerFecha ;
      new web.getrangoperiodos(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV20LiqNro, AV17LegNumero, AV19TLiqCod, AV15LegClase, AV13LiqPeriodo, false, GXv_date5, GXv_date6) ;
      remuneracionferiadonotrabajado.this.AV35desdeFerFecha = GXv_date5[0] ;
      remuneracionferiadonotrabajado.this.AV36hastaFerFecha = GXv_date6[0] ;
      GXv_char3[0] = "" ;
      GXv_date6[0] = AV64LegFecEgreso ;
      new web.empleadogetegreso(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV17LegNumero, GXv_char3, GXv_date6) ;
      remuneracionferiadonotrabajado.this.AV64LegFecEgreso = GXv_date6[0] ;
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV64LegFecEgreso)) && (( GXutil.resetTime(AV64LegFecEgreso).before( GXutil.resetTime( AV36hastaFerFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV64LegFecEgreso), GXutil.resetTime(AV36hastaFerFecha)) )) )
      {
         AV36hastaFerFecha = GXutil.dadd( AV64LegFecEgreso, (-1)) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, httpContext.getMessage( "&&LegClase ", "")+GXutil.trim( GXutil.str( AV15LegClase, 1, 0))) ;
      if ( AV15LegClase == 2 )
      {
      }
      else
      {
         GXv_char3[0] = AV43auxError ;
         GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
         new web.obtsueldojornal(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV20LiqNro, AV17LegNumero, AV13LiqPeriodo, GXv_char3, GXv_decimal7) ;
         remuneracionferiadonotrabajado.this.AV43auxError = GXv_char3[0] ;
         if ( ! (GXutil.strcmp("", AV43auxError)==0) )
         {
            AV46LiqDCalculado = (byte)(0) ;
            AV27error = GXutil.trim( AV43auxError) ;
            AV45LiqDLog = GXutil.trim( AV27error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_int2[0] = AV26diasMes ;
         new web.diasmes(remoteHandle, context).execute( AV12CliCod, AV13LiqPeriodo, GXv_int2) ;
         remuneracionferiadonotrabajado.this.AV26diasMes = (byte)((byte)(GXv_int2[0])) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, "..") ;
      GXv_char3[0] = AV54LegConveCodigo ;
      GXv_char8[0] = AV56LegReligion ;
      GXv_char9[0] = AV55LegOrigen ;
      GXv_boolean10[0] = AV53empresaliquidaReligion ;
      GXv_boolean11[0] = AV52empresaliquidaOrigen ;
      GXv_boolean12[0] = AV51empresaliquidaConvenio ;
      new web.getreligorigconvenio(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV17LegNumero, AV11PaiCod, GXv_char3, GXv_char8, GXv_char9, GXv_boolean10, GXv_boolean11, GXv_boolean12) ;
      remuneracionferiadonotrabajado.this.AV54LegConveCodigo = GXv_char3[0] ;
      remuneracionferiadonotrabajado.this.AV56LegReligion = GXv_char8[0] ;
      remuneracionferiadonotrabajado.this.AV55LegOrigen = GXv_char9[0] ;
      remuneracionferiadonotrabajado.this.AV53empresaliquidaReligion = GXv_boolean10[0] ;
      remuneracionferiadonotrabajado.this.AV52empresaliquidaOrigen = GXv_boolean11[0] ;
      remuneracionferiadonotrabajado.this.AV51empresaliquidaConvenio = GXv_boolean12[0] ;
      GXv_char9[0] = AV74tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV20LiqNro, AV17LegNumero, AV11PaiCod, "", "", GXv_char9) ;
      remuneracionferiadonotrabajado.this.AV74tipo_tarifa = GXv_char9[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, httpContext.getMessage( "&PaiCod ", "")+GXutil.trim( GXutil.str( AV11PaiCod, 4, 0))+httpContext.getMessage( " &desdeFerFecha ", "")+GXutil.trim( localUtil.dtoc( AV35desdeFerFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &hastaFerFecha ", "")+GXutil.trim( localUtil.dtoc( AV36hastaFerFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &FerTipo ", "")+AV63FerTipo) ;
      AV79GXLvl41 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV63FerTipo ,
                                           A1233FeriadoTipo ,
                                           A1227FerFecha ,
                                           AV35desdeFerFecha ,
                                           AV36hastaFerFecha ,
                                           Short.valueOf(AV11PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P013O2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV11PaiCod), AV35desdeFerFecha, AV36hastaFerFecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1223FerId = P013O2_A1223FerId[0] ;
         A1233FeriadoTipo = P013O2_A1233FeriadoTipo[0] ;
         A1227FerFecha = P013O2_A1227FerFecha[0] ;
         A46PaiCod = P013O2_A46PaiCod[0] ;
         A1230FerReligId = P013O2_A1230FerReligId[0] ;
         n1230FerReligId = P013O2_n1230FerReligId[0] ;
         A1232FerOrigId = P013O2_A1232FerOrigId[0] ;
         n1232FerOrigId = P013O2_n1232FerOrigId[0] ;
         A1234FeriadoConvenio = P013O2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P013O2_n1234FeriadoConvenio[0] ;
         A1228FerDescrip = P013O2_A1228FerDescrip[0] ;
         A1226FerAnio = P013O2_A1226FerAnio[0] ;
         A1233FeriadoTipo = P013O2_A1233FeriadoTipo[0] ;
         A1230FerReligId = P013O2_A1230FerReligId[0] ;
         n1230FerReligId = P013O2_n1230FerReligId[0] ;
         A1232FerOrigId = P013O2_A1232FerOrigId[0] ;
         n1232FerOrigId = P013O2_n1232FerOrigId[0] ;
         A1234FeriadoConvenio = P013O2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P013O2_n1234FeriadoConvenio[0] ;
         A1228FerDescrip = P013O2_A1228FerDescrip[0] ;
         AV79GXLvl41 = (byte)(1) ;
         GXv_boolean12[0] = AV50liquida ;
         new web.evaluanolaborable(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV17LegNumero, A1227FerFecha, AV15LegClase, A1230FerReligId, AV56LegReligion, AV53empresaliquidaReligion, A1232FerOrigId, AV55LegOrigen, AV52empresaliquidaOrigen, A1234FeriadoConvenio, AV54LegConveCodigo, AV51empresaliquidaConvenio, GXv_boolean12) ;
         remuneracionferiadonotrabajado.this.AV50liquida = GXv_boolean12[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, httpContext.getMessage( "FerFecha ", "")+GXutil.trim( localUtil.dtoc( A1227FerFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liquida ", "")+GXutil.trim( GXutil.booltostr( AV50liquida))) ;
         if ( AV50liquida )
         {
            AV62hayFeriadoTrabajado = false ;
            GXv_boolean12[0] = AV34hayLicenciaQueAbsorbe ;
            GXv_char9[0] = "" ;
            new web.haylicenciaqueabsorbefer(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV17LegNumero, A1227FerFecha, A1227FerFecha, GXv_boolean12, GXv_char9) ;
            remuneracionferiadonotrabajado.this.AV34hayLicenciaQueAbsorbe = GXv_boolean12[0] ;
            if ( ! AV34hayLicenciaQueAbsorbe )
            {
               GXv_boolean12[0] = AV62hayFeriadoTrabajado ;
               new web.hayferiadotrabajado(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV17LegNumero, A1227FerFecha, A1227FerFecha, GXv_boolean12) ;
               remuneracionferiadonotrabajado.this.AV62hayFeriadoTrabajado = GXv_boolean12[0] ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, httpContext.getMessage( "&hayLicenciaQueAbsorbe ", "")+GXutil.trim( GXutil.booltostr( AV34hayLicenciaQueAbsorbe))+httpContext.getMessage( " &hayFeriadoTrabajado ", "")+GXutil.trim( GXutil.booltostr( AV62hayFeriadoTrabajado))) ;
            if ( ! AV34hayLicenciaQueAbsorbe && ! AV62hayFeriadoTrabajado )
            {
               AV45LiqDLog += httpContext.getMessage( "<b>", "") + GXutil.trim( localUtil.dtoc( A1227FerFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + " " + GXutil.trim( A1228FerDescrip) + httpContext.getMessage( "</b>: ", "") ;
               GXv_decimal7[0] = AV41feriadoImportes ;
               GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
               GXv_int4[0] = AV42auxLiqDCalculado ;
               GXv_char9[0] = AV43auxError ;
               GXv_char8[0] = AV44auxLiqDLog ;
               GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal15[0] = AV71horasJornada ;
               new web.remuneracionlicencia5(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV20LiqNro, AV67LiqRelNro, AV17LegNumero, A1227FerFecha, "[feriados_no_trabajados]", AV39ConCodigo, DecimalUtil.doubleToDec(1), A1227FerFecha, false, AV31ProcesoLiquidacion, AV65llamador, AV40insertandoConceptos, GXv_decimal7, GXv_decimal13, GXv_int4, GXv_char9, GXv_char8, GXv_decimal14, GXv_decimal15) ;
               remuneracionferiadonotrabajado.this.AV41feriadoImportes = GXv_decimal7[0] ;
               remuneracionferiadonotrabajado.this.AV42auxLiqDCalculado = GXv_int4[0] ;
               remuneracionferiadonotrabajado.this.AV43auxError = GXv_char9[0] ;
               remuneracionferiadonotrabajado.this.AV44auxLiqDLog = GXv_char8[0] ;
               remuneracionferiadonotrabajado.this.AV71horasJornada = GXv_decimal15[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, httpContext.getMessage( "procesa", "")) ;
               if ( AV42auxLiqDCalculado == 0 )
               {
                  AV27error = httpContext.getMessage( "No se pudo calcular importe para feriado (", "") + GXutil.trim( AV43auxError) + ")" ;
                  /* Execute user subroutine: 'ERROR' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               if ( GXutil.strcmp(AV74tipo_tarifa, "P") == 0 )
               {
                  AV9cantidad = AV9cantidad.add(DecimalUtil.doubleToDec(1)) ;
               }
               else
               {
                  AV9cantidad = AV9cantidad.add(AV71horasJornada) ;
               }
               AV45LiqDLog += GXutil.trim( AV44auxLiqDLog) + httpContext.getMessage( ".<br>", "") ;
               AV8Importes = AV8Importes.add(AV41feriadoImportes) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, httpContext.getMessage( "&feriadoImportes ", "")+GXutil.trim( GXutil.str( AV41feriadoImportes, 14, 2))+httpContext.getMessage( " &LiqDLog ", "")+GXutil.trim( AV45LiqDLog)) ;
               GXv_char9[0] = AV70auxConCodigo ;
               new web.getparametro(remoteHandle, context).execute( AV12CliCod, new web.feriadostrabajadoshoras_codigoparam(remoteHandle, context).executeUdp( ), GXv_char9) ;
               remuneracionferiadonotrabajado.this.AV70auxConCodigo = GXv_char9[0] ;
               GXv_decimal15[0] = AV69auxLiqDImpCalcu ;
               GXv_decimal14[0] = AV72auxLiqDCanti ;
               GXv_boolean12[0] = false ;
               GXv_int4[0] = AV42auxLiqDCalculado ;
               new web.getliqdimpcalcuycanti(remoteHandle, context).execute( AV12CliCod, AV16EmpCod, AV20LiqNro, AV17LegNumero, AV70auxConCodigo, AV31ProcesoLiquidacion, GXv_decimal15, GXv_decimal14, GXv_boolean12, GXv_int4) ;
               remuneracionferiadonotrabajado.this.AV69auxLiqDImpCalcu = GXv_decimal15[0] ;
               remuneracionferiadonotrabajado.this.AV72auxLiqDCanti = GXv_decimal14[0] ;
               remuneracionferiadonotrabajado.this.AV42auxLiqDCalculado = GXv_int4[0] ;
               if ( AV42auxLiqDCalculado == 0 )
               {
                  AV27error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV70auxConCodigo) ;
                  /* Execute user subroutine: 'ERROR' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               if ( AV69auxLiqDImpCalcu.doubleValue() > 0 )
               {
                  AV45LiqDLog += httpContext.getMessage( ". Se resta ", "") + GXutil.trim( GXutil.str( AV69auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de horas de feriado trabajado", "") ;
                  AV8Importes = AV8Importes.subtract(AV69auxLiqDImpCalcu) ;
                  if ( GXutil.strcmp(AV74tipo_tarifa, "H") == 0 )
                  {
                     AV9cantidad = AV9cantidad.subtract(AV72auxLiqDCanti) ;
                  }
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV79GXLvl41 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ERROR' Routine */
      returnInSub = false ;
      AV46LiqDCalculado = (byte)(0) ;
      AV45LiqDLog = GXutil.trim( AV27error) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV78Pgmname, httpContext.getMessage( "&error ", "")+AV27error) ;
      returnInSub = true;
      if (true) return;
   }

   protected void cleanup( )
   {
      this.aP11[0] = remuneracionferiadonotrabajado.this.AV8Importes;
      this.aP12[0] = remuneracionferiadonotrabajado.this.AV27error;
      this.aP13[0] = remuneracionferiadonotrabajado.this.AV46LiqDCalculado;
      this.aP14[0] = remuneracionferiadonotrabajado.this.AV9cantidad;
      this.aP15[0] = remuneracionferiadonotrabajado.this.AV45LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Importes = DecimalUtil.ZERO ;
      AV27error = "" ;
      AV9cantidad = DecimalUtil.ZERO ;
      AV45LiqDLog = "" ;
      AV78Pgmname = "" ;
      AV19TLiqCod = "" ;
      AV35desdeFerFecha = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV36hastaFerFecha = GXutil.nullDate() ;
      AV64LegFecEgreso = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV43auxError = "" ;
      GXv_int2 = new short[1] ;
      AV54LegConveCodigo = "" ;
      GXv_char3 = new String[1] ;
      AV56LegReligion = "" ;
      AV55LegOrigen = "" ;
      GXv_boolean10 = new boolean[1] ;
      GXv_boolean11 = new boolean[1] ;
      AV74tipo_tarifa = "" ;
      scmdbuf = "" ;
      A1233FeriadoTipo = "" ;
      A1227FerFecha = GXutil.nullDate() ;
      P013O2_A1223FerId = new String[] {""} ;
      P013O2_A1233FeriadoTipo = new String[] {""} ;
      P013O2_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P013O2_A46PaiCod = new short[1] ;
      P013O2_A1230FerReligId = new String[] {""} ;
      P013O2_n1230FerReligId = new boolean[] {false} ;
      P013O2_A1232FerOrigId = new String[] {""} ;
      P013O2_n1232FerOrigId = new boolean[] {false} ;
      P013O2_A1234FeriadoConvenio = new String[] {""} ;
      P013O2_n1234FeriadoConvenio = new boolean[] {false} ;
      P013O2_A1228FerDescrip = new String[] {""} ;
      P013O2_A1226FerAnio = new short[1] ;
      A1223FerId = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      A1234FeriadoConvenio = "" ;
      A1228FerDescrip = "" ;
      AV41feriadoImportes = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      AV44auxLiqDLog = "" ;
      GXv_char8 = new String[1] ;
      AV71horasJornada = DecimalUtil.ZERO ;
      AV70auxConCodigo = "" ;
      GXv_char9 = new String[1] ;
      AV69auxLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      AV72auxLiqDCanti = DecimalUtil.ZERO ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXv_int4 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.remuneracionferiadonotrabajado__default(),
         new Object[] {
             new Object[] {
            P013O2_A1223FerId, P013O2_A1233FeriadoTipo, P013O2_A1227FerFecha, P013O2_A46PaiCod, P013O2_A1230FerReligId, P013O2_n1230FerReligId, P013O2_A1232FerOrigId, P013O2_n1232FerOrigId, P013O2_A1234FeriadoConvenio, P013O2_n1234FeriadoConvenio,
            P013O2_A1228FerDescrip, P013O2_A1226FerAnio
            }
         }
      );
      AV78Pgmname = "RemuneracionFeriadoNoTrabajado" ;
      /* GeneXus formulas. */
      AV78Pgmname = "RemuneracionFeriadoNoTrabajado" ;
      Gx_err = (short)(0) ;
   }

   private byte AV46LiqDCalculado ;
   private byte AV15LegClase ;
   private byte AV26diasMes ;
   private byte AV79GXLvl41 ;
   private byte AV42auxLiqDCalculado ;
   private byte GXv_int4[] ;
   private short AV16EmpCod ;
   private short AV11PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short A1226FerAnio ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV17LegNumero ;
   private int AV20LiqNro ;
   private int AV67LiqRelNro ;
   private java.math.BigDecimal AV8Importes ;
   private java.math.BigDecimal AV9cantidad ;
   private java.math.BigDecimal AV41feriadoImportes ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal AV71horasJornada ;
   private java.math.BigDecimal AV69auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private java.math.BigDecimal AV72auxLiqDCanti ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private String AV39ConCodigo ;
   private String AV63FerTipo ;
   private String AV31ProcesoLiquidacion ;
   private String AV65llamador ;
   private String AV78Pgmname ;
   private String AV19TLiqCod ;
   private String AV54LegConveCodigo ;
   private String GXv_char3[] ;
   private String AV56LegReligion ;
   private String AV55LegOrigen ;
   private String AV74tipo_tarifa ;
   private String scmdbuf ;
   private String A1233FeriadoTipo ;
   private String A1223FerId ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String A1234FeriadoConvenio ;
   private String GXv_char8[] ;
   private String AV70auxConCodigo ;
   private String GXv_char9[] ;
   private java.util.Date AV13LiqPeriodo ;
   private java.util.Date AV35desdeFerFecha ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date AV36hastaFerFecha ;
   private java.util.Date AV64LegFecEgreso ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date A1227FerFecha ;
   private boolean AV40insertandoConceptos ;
   private boolean returnInSub ;
   private boolean AV53empresaliquidaReligion ;
   private boolean GXv_boolean10[] ;
   private boolean AV52empresaliquidaOrigen ;
   private boolean GXv_boolean11[] ;
   private boolean AV51empresaliquidaConvenio ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private boolean n1234FeriadoConvenio ;
   private boolean AV50liquida ;
   private boolean AV62hayFeriadoTrabajado ;
   private boolean AV34hayLicenciaQueAbsorbe ;
   private boolean GXv_boolean12[] ;
   private String AV45LiqDLog ;
   private String AV44auxLiqDLog ;
   private String AV27error ;
   private String AV43auxError ;
   private String A1228FerDescrip ;
   private String[] aP15 ;
   private java.math.BigDecimal[] aP11 ;
   private String[] aP12 ;
   private byte[] aP13 ;
   private java.math.BigDecimal[] aP14 ;
   private IDataStoreProvider pr_default ;
   private String[] P013O2_A1223FerId ;
   private String[] P013O2_A1233FeriadoTipo ;
   private java.util.Date[] P013O2_A1227FerFecha ;
   private short[] P013O2_A46PaiCod ;
   private String[] P013O2_A1230FerReligId ;
   private boolean[] P013O2_n1230FerReligId ;
   private String[] P013O2_A1232FerOrigId ;
   private boolean[] P013O2_n1232FerOrigId ;
   private String[] P013O2_A1234FeriadoConvenio ;
   private boolean[] P013O2_n1234FeriadoConvenio ;
   private String[] P013O2_A1228FerDescrip ;
   private short[] P013O2_A1226FerAnio ;
}

final  class remuneracionferiadonotrabajado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P013O2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV63FerTipo ,
                                          String A1233FeriadoTipo ,
                                          java.util.Date A1227FerFecha ,
                                          java.util.Date AV35desdeFerFecha ,
                                          java.util.Date AV36hastaFerFecha ,
                                          short AV11PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[3];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT T1.FerId, T2.FeriadoTipo, T1.FerFecha, T1.PaiCod, T2.FerReligId, T2.FerOrigId, T2.FeriadoConvenio, T2.FerDescrip, T1.FerAnio FROM (feriado_agenda T1 INNER" ;
      scmdbuf += " JOIN feriado T2 ON T2.PaiCod = T1.PaiCod AND T2.FerId = T1.FerId)" ;
      addWhere(sWhereString, "(T1.PaiCod = ?)");
      addWhere(sWhereString, "(T1.FerFecha >= ?)");
      addWhere(sWhereString, "(T1.FerFecha <= ?)");
      if ( GXutil.strcmp(AV63FerTipo, "nolaborable") == 0 )
      {
         addWhere(sWhereString, "(T2.FeriadoTipo = ( 'nolaborable'))");
      }
      if ( GXutil.strcmp(AV63FerTipo, "nolaborable") != 0 )
      {
         addWhere(sWhereString, "(T2.FeriadoTipo <> ( 'nolaborable'))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.PaiCod" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
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
                  return conditional_P013O2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P013O2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
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
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[4]);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[5]);
               }
               return;
      }
   }

}

