package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class genconcepporlegajo7 extends GXProcedure
{
   public genconcepporlegajo7( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( genconcepporlegajo7.class ), "" );
   }

   public genconcepporlegajo7( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              int aP4 ,
                              java.util.Date aP5 ,
                              int aP6 ,
                              boolean aP7 ,
                              String aP8 ,
                              String aP9 ,
                              int aP10 ,
                              boolean aP11 ,
                              String[] aP12 ,
                              int[] aP13 ,
                              boolean[] aP14 ,
                              GXSimpleCollection<String>[] aP15 ,
                              GXSimpleCollection<String>[] aP16 ,
                              byte[] aP17 )
   {
      genconcepporlegajo7.this.aP18 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
      return aP18[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        int aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        String aP9 ,
                        int aP10 ,
                        boolean aP11 ,
                        String[] aP12 ,
                        int[] aP13 ,
                        boolean[] aP14 ,
                        GXSimpleCollection<String>[] aP15 ,
                        GXSimpleCollection<String>[] aP16 ,
                        byte[] aP17 ,
                        boolean[] aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             int aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             String aP9 ,
                             int aP10 ,
                             boolean aP11 ,
                             String[] aP12 ,
                             int[] aP13 ,
                             boolean[] aP14 ,
                             GXSimpleCollection<String>[] aP15 ,
                             GXSimpleCollection<String>[] aP16 ,
                             byte[] aP17 ,
                             boolean[] aP18 )
   {
      genconcepporlegajo7.this.AV38CliCod = aP0;
      genconcepporlegajo7.this.AV71EmpCod = aP1;
      genconcepporlegajo7.this.AV112LiqNro = aP2;
      genconcepporlegajo7.this.AV174TLiqCod = aP3;
      genconcepporlegajo7.this.AV101LegNumero = aP4;
      genconcepporlegajo7.this.AV114LiqPeriodo = aP5;
      genconcepporlegajo7.this.AV177ultimoLiqDSecuencial = aP6;
      genconcepporlegajo7.this.AV146resolver = aP7;
      genconcepporlegajo7.this.AV8ConveCodigo = aP8;
      genconcepporlegajo7.this.AV11accionPalabra = aP9;
      genconcepporlegajo7.this.AV115LiqRelNro = aP10;
      genconcepporlegajo7.this.AV186LiqSac = aP11;
      genconcepporlegajo7.this.aP12 = aP12;
      genconcepporlegajo7.this.aP13 = aP13;
      genconcepporlegajo7.this.aP14 = aP14;
      genconcepporlegajo7.this.aP15 = aP15;
      genconcepporlegajo7.this.aP16 = aP16;
      genconcepporlegajo7.this.aP17 = aP17;
      genconcepporlegajo7.this.aP18 = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV187liq_nivel_complejidad = (byte)(3) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( " inicio clicod ", "")+GXutil.trim( GXutil.str( AV38CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV71EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV101LegNumero, 8, 0))+httpContext.getMessage( " &LiqFecha ", "")+GXutil.trim( localUtil.dtoc( AV109LiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      GXt_char1 = AV120mensualTLiqCod ;
      GXt_char2 = AV120mensualTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      genconcepporlegajo7.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV38CliCod, GXt_char2, GXv_char4) ;
      genconcepporlegajo7.this.GXt_char1 = GXv_char4[0] ;
      AV120mensualTLiqCod = GXt_char1 ;
      GXv_char4[0] = AV10parmValue ;
      new web.getparametro(remoteHandle, context).execute( AV38CliCod, new web.desghortrayadi_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      genconcepporlegajo7.this.AV10parmValue = GXv_char4[0] ;
      AV197desglosar_HorTraYAdiPorDia = GXutil.boolval( AV10parmValue) ;
      GXv_int5[0] = AV9LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV101LegNumero, GXv_int5) ;
      genconcepporlegajo7.this.AV9LegClase = GXv_int5[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, "1") ;
      if ( ( GXutil.strcmp(AV174TLiqCod, AV120mensualTLiqCod) == 0 ) || ( GXutil.strcmp(AV174TLiqCod, AV143quincenaTLiqCod) == 0 ) )
      {
         GXt_char2 = AV70egresoTLiqCod ;
         GXt_char1 = AV70egresoTLiqCod ;
         GXv_char4[0] = GXt_char1 ;
         new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         genconcepporlegajo7.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV38CliCod, GXt_char1, GXv_char3) ;
         genconcepporlegajo7.this.GXt_char2 = GXv_char3[0] ;
         AV70egresoTLiqCod = GXt_char2 ;
         GXv_date6[0] = AV98LegFecIngreso ;
         GXv_date7[0] = AV97LegFecEgreso ;
         new web.getfecingresoyegreso(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV101LegNumero, GXv_date6, GXv_date7) ;
         genconcepporlegajo7.this.AV98LegFecIngreso = GXv_date6[0] ;
         genconcepporlegajo7.this.AV97LegFecEgreso = GXv_date7[0] ;
         GXt_char2 = AV10parmValue ;
         GXt_char1 = AV10parmValue ;
         GXv_char4[0] = GXt_char1 ;
         new web.meses30dias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         genconcepporlegajo7.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV38CliCod, GXt_char1, GXv_char3) ;
         genconcepporlegajo7.this.GXt_char2 = GXv_char3[0] ;
         AV10parmValue = GXt_char2 ;
         AV175todosLosMeses30 = GXutil.boolval( AV10parmValue) ;
         GXv_int5[0] = AV72EmpTipoExp ;
         new web.getemptipoexp(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, GXv_int5) ;
         genconcepporlegajo7.this.AV72EmpTipoExp = GXv_int5[0] ;
         GXv_int8[0] = AV63dias_trabajados ;
         GXv_int9[0] = AV32cant_basica ;
         GXv_char4[0] = "" ;
         new web.cantinicialdiastrabajados(remoteHandle, context).execute( AV38CliCod, AV174TLiqCod, AV70egresoTLiqCod, AV9LegClase, AV98LegFecIngreso, AV97LegFecEgreso, AV114LiqPeriodo, AV175todosLosMeses30, AV72EmpTipoExp, GXv_int8, GXv_int9, GXv_char4) ;
         genconcepporlegajo7.this.AV63dias_trabajados = GXv_int8[0] ;
         genconcepporlegajo7.this.AV32cant_basica = GXv_int9[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, "2") ;
         if ( AV32cant_basica == AV63dias_trabajados )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, "3") ;
            if ( ! AV186LiqSac )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, "4") ;
               if ( (0==AV115LiqRelNro) )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, "5") ;
                  GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_char4[0] = AV189tipo_sueldo ;
                  GXv_int9[0] = AV190LegSuelSec ;
                  GXv_boolean11[0] = false ;
                  new web.getlegajosueldoultimo(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, 0, AV101LegNumero, AV114LiqPeriodo, GXv_decimal10, GXv_char4, GXv_int9, GXv_boolean11) ;
                  genconcepporlegajo7.this.AV189tipo_sueldo = GXv_char4[0] ;
                  genconcepporlegajo7.this.AV190LegSuelSec = GXv_int9[0] ;
                  GXv_boolean11[0] = AV191LegSuelBasica ;
                  new web.determinalegsuelbasica(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV112LiqNro, AV101LegNumero, AV174TLiqCod, AV114LiqPeriodo, AV190LegSuelSec, "", GXv_boolean11) ;
                  genconcepporlegajo7.this.AV191LegSuelBasica = GXv_boolean11[0] ;
                  if ( AV191LegSuelBasica )
                  {
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, "6") ;
                     AV187liq_nivel_complejidad = (byte)(1) ;
                     AV46conceptosOK = true ;
                     GXv_char4[0] = AV184redondeoConCodigo ;
                     new web.getparametro(remoteHandle, context).execute( AV38CliCod, new web.concepto_redondeo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
                     genconcepporlegajo7.this.AV184redondeoConCodigo = GXv_char4[0] ;
                     GXv_boolean11[0] = AV185redondeoHay ;
                     new web.legsuelhayconcepto(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV101LegNumero, AV190LegSuelSec, AV184redondeoConCodigo, GXv_boolean11) ;
                     genconcepporlegajo7.this.AV185redondeoHay = GXv_boolean11[0] ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "7 &LegSuelSec ", "")+GXutil.trim( GXutil.str( AV190LegSuelSec, 4, 0))) ;
                     new web.insert_into_select_from_sueldolegajo(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV112LiqNro, AV101LegNumero, AV114LiqPeriodo, AV190LegSuelSec, AV174TLiqCod) ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, "8") ;
                  }
               }
            }
         }
      }
      GXv_int9[0] = AV136paicod ;
      new web.clientegetpais(remoteHandle, context).execute( AV38CliCod, GXv_int9) ;
      genconcepporlegajo7.this.AV136paicod = GXv_int9[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "&liq_nivel_complejidad A: ", "")+GXutil.trim( GXutil.str( AV187liq_nivel_complejidad, 1, 0))) ;
      if ( AV187liq_nivel_complejidad != 1 )
      {
         GXt_dtime12 = AV41comienzo3 ;
         GXv_dtime13[0] = GXt_dtime12 ;
         new web.getahora(remoteHandle, context).execute( AV38CliCod, GXv_dtime13) ;
         genconcepporlegajo7.this.GXt_dtime12 = GXv_dtime13[0] ;
         AV41comienzo3 = GXt_dtime12 ;
         AV108LiqDSecuencial = AV177ultimoLiqDSecuencial ;
         AV46conceptosOK = true ;
         GXv_date7[0] = AV141primerDiaPeriodo ;
         GXv_date6[0] = AV176ultimoDiaPeriodo ;
         new web.getrangoagendaliquidacion(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV112LiqNro, AV101LegNumero, AV114LiqPeriodo, AV174TLiqCod, AV9LegClase, GXv_date7, GXv_date6) ;
         genconcepporlegajo7.this.AV141primerDiaPeriodo = GXv_date7[0] ;
         genconcepporlegajo7.this.AV176ultimoDiaPeriodo = GXv_date6[0] ;
         AV107LiqDLote = (byte)(1) ;
         AV124Mostrarconcepto = (byte)(0) ;
         AV130novedadConCodigo.clear();
         new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "carga novedades &ultimoDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV176ultimoDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &primerDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV141primerDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         AV22appendLiqLog = httpContext.getMessage( "Legajo ", "") + GXutil.trim( GXutil.str( AV101LegNumero, 8, 0)) ;
         GXv_char4[0] = AV110LiqLog ;
         new web.actualizalogliquidacionvar(remoteHandle, context).execute( AV38CliCod, AV22appendLiqLog, GXv_char4) ;
         genconcepporlegajo7.this.AV110LiqLog = GXv_char4[0] ;
         GXt_dtime12 = AV42comienzo4 ;
         GXv_dtime13[0] = GXt_dtime12 ;
         new web.getahora(remoteHandle, context).execute( AV38CliCod, GXv_dtime13) ;
         genconcepporlegajo7.this.GXt_dtime12 = GXv_dtime13[0] ;
         AV42comienzo4 = GXt_dtime12 ;
         GXv_char4[0] = AV150retroPalabra ;
         new web.codigoopeformula(remoteHandle, context).execute( AV38CliCod, "{retroactivo}", false, true, GXv_char4) ;
         genconcepporlegajo7.this.AV150retroPalabra = GXv_char4[0] ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Integer.valueOf(AV115LiqRelNro) ,
                                              Integer.valueOf(A1254AgeLiqNro) ,
                                              A111AgeFecDes ,
                                              AV176ultimoDiaPeriodo ,
                                              A112AgeFecHas ,
                                              AV141primerDiaPeriodo ,
                                              Boolean.valueOf(A150ConHabilitado) ,
                                              Integer.valueOf(AV38CliCod) ,
                                              Short.valueOf(AV71EmpCod) ,
                                              Integer.valueOf(AV101LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                              TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         /* Using cursor P02CK2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV71EmpCod), Integer.valueOf(AV101LegNumero), AV176ultimoDiaPeriodo, AV141primerDiaPeriodo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            brk2CK2 = false ;
            A113AgeImporte = P02CK2_A113AgeImporte[0] ;
            n113AgeImporte = P02CK2_n113AgeImporte[0] ;
            A110AgeCanti = P02CK2_A110AgeCanti[0] ;
            n110AgeCanti = P02CK2_n110AgeCanti[0] ;
            A115AgeVUnit = P02CK2_A115AgeVUnit[0] ;
            n115AgeVUnit = P02CK2_n115AgeVUnit[0] ;
            A148ConFormula = P02CK2_A148ConFormula[0] ;
            n148ConFormula = P02CK2_n148ConFormula[0] ;
            A112AgeFecHas = P02CK2_A112AgeFecHas[0] ;
            n112AgeFecHas = P02CK2_n112AgeFecHas[0] ;
            A1826ConPueNov = P02CK2_A1826ConPueNov[0] ;
            A1254AgeLiqNro = P02CK2_A1254AgeLiqNro[0] ;
            n1254AgeLiqNro = P02CK2_n1254AgeLiqNro[0] ;
            A111AgeFecDes = P02CK2_A111AgeFecDes[0] ;
            n111AgeFecDes = P02CK2_n111AgeFecDes[0] ;
            A26ConCodigo = P02CK2_A26ConCodigo[0] ;
            A6LegNumero = P02CK2_A6LegNumero[0] ;
            A1EmpCod = P02CK2_A1EmpCod[0] ;
            A3CliCod = P02CK2_A3CliCod[0] ;
            A150ConHabilitado = P02CK2_A150ConHabilitado[0] ;
            A25AgeOrden = P02CK2_A25AgeOrden[0] ;
            A148ConFormula = P02CK2_A148ConFormula[0] ;
            n148ConFormula = P02CK2_n148ConFormula[0] ;
            A1826ConPueNov = P02CK2_A1826ConPueNov[0] ;
            A150ConHabilitado = P02CK2_A150ConHabilitado[0] ;
            AV48ConCodigo = A26ConCodigo ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "novedad &ConCodigo ", "")+GXutil.trim( AV48ConCodigo)+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV71EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV101LegNumero, 8, 0))+httpContext.getMessage( " &LiqFecha ", "")+GXutil.trim( localUtil.dtoc( AV109LiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            AV22appendLiqLog = httpContext.getMessage( "Recorre novedad ConCodigo ", "") + GXutil.trim( A26ConCodigo) ;
            GXv_char4[0] = AV110LiqLog ;
            new web.actualizalogliquidacionvar(remoteHandle, context).execute( AV38CliCod, AV22appendLiqLog, GXv_char4) ;
            genconcepporlegajo7.this.AV110LiqLog = GXv_char4[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, "2") ;
            /* Execute user subroutine: 'APLICACIERTASLIQUIDACIONES' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( AV113LiqOK )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "3 ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " AgeCanti ", "")+GXutil.trim( GXutil.str( A110AgeCanti, 9, 2))+httpContext.getMessage( " AgeVUnit ", "")+GXutil.trim( GXutil.str( A115AgeVUnit, 14, 2))+httpContext.getMessage( " AgeImporte ", "")+GXutil.trim( GXutil.str( A113AgeImporte, 14, 2))+httpContext.getMessage( " &estaEnLiqAntDelPeriodo ", "")+GXutil.trim( GXutil.booltostr( AV75estaEnLiqAntDelPeriodo))) ;
               AV130novedadConCodigo.add(A26ConCodigo, 0);
               AV15AgeImporte = DecimalUtil.ZERO ;
               AV14AgeCanti = DecimalUtil.ZERO ;
               AV16AgeVUnit = DecimalUtil.ZERO ;
               while ( (pr_default.getStatus(0) != 101) && ( P02CK2_A3CliCod[0] == A3CliCod ) && ( P02CK2_A1EmpCod[0] == A1EmpCod ) && ( P02CK2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P02CK2_A26ConCodigo[0], A26ConCodigo) == 0 ) )
               {
                  brk2CK2 = false ;
                  A113AgeImporte = P02CK2_A113AgeImporte[0] ;
                  n113AgeImporte = P02CK2_n113AgeImporte[0] ;
                  A110AgeCanti = P02CK2_A110AgeCanti[0] ;
                  n110AgeCanti = P02CK2_n110AgeCanti[0] ;
                  A115AgeVUnit = P02CK2_A115AgeVUnit[0] ;
                  n115AgeVUnit = P02CK2_n115AgeVUnit[0] ;
                  A148ConFormula = P02CK2_A148ConFormula[0] ;
                  n148ConFormula = P02CK2_n148ConFormula[0] ;
                  A112AgeFecHas = P02CK2_A112AgeFecHas[0] ;
                  n112AgeFecHas = P02CK2_n112AgeFecHas[0] ;
                  A1826ConPueNov = P02CK2_A1826ConPueNov[0] ;
                  A1254AgeLiqNro = P02CK2_A1254AgeLiqNro[0] ;
                  n1254AgeLiqNro = P02CK2_n1254AgeLiqNro[0] ;
                  A111AgeFecDes = P02CK2_A111AgeFecDes[0] ;
                  n111AgeFecDes = P02CK2_n111AgeFecDes[0] ;
                  A25AgeOrden = P02CK2_A25AgeOrden[0] ;
                  A148ConFormula = P02CK2_A148ConFormula[0] ;
                  n148ConFormula = P02CK2_n148ConFormula[0] ;
                  A1826ConPueNov = P02CK2_A1826ConPueNov[0] ;
                  if ( AV197desglosar_HorTraYAdiPorDia )
                  {
                     AV15AgeImporte = A113AgeImporte ;
                     AV14AgeCanti = A110AgeCanti ;
                     AV16AgeVUnit = A115AgeVUnit ;
                     AV53ConFormula = A148ConFormula ;
                     AV194AgeFecDes = A111AgeFecDes ;
                     AV198AgeFecHas = A112AgeFecHas ;
                     AV195ConPueNov = A1826ConPueNov ;
                     /* Execute user subroutine: 'AGREGAR DETALLE' */
                     S121 ();
                     if ( returnInSub )
                     {
                        pr_default.close(0);
                        pr_default.close(0);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
                  else
                  {
                     AV15AgeImporte = AV15AgeImporte.add(A113AgeImporte) ;
                     AV14AgeCanti = AV14AgeCanti.add(A110AgeCanti) ;
                     AV16AgeVUnit = AV16AgeVUnit.add(A115AgeVUnit) ;
                  }
                  if ( P02CK2_n1254AgeLiqNro[0] )
                  {
                     A1254AgeLiqNro = AV112LiqNro ;
                     n1254AgeLiqNro = false ;
                  }
                  /* Using cursor P02CK3 */
                  pr_default.execute(1, new Object[] {Boolean.valueOf(n1254AgeLiqNro), Integer.valueOf(A1254AgeLiqNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
                  brk2CK2 = true ;
                  pr_default.readNext(0);
               }
               if ( ! AV197desglosar_HorTraYAdiPorDia )
               {
                  AV53ConFormula = A148ConFormula ;
                  AV194AgeFecDes = A111AgeFecDes ;
                  AV198AgeFecHas = A112AgeFecHas ;
                  AV195ConPueNov = A1826ConPueNov ;
                  /* Execute user subroutine: 'AGREGAR DETALLE' */
                  S121 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "agenda NewLiquidacionDetalle2", "")) ;
            }
            else
            {
            }
            if ( ! brk2CK2 )
            {
               brk2CK2 = true ;
               pr_default.readNext(0);
            }
         }
         pr_default.close(0);
         AV116liquidacionSimple = false ;
         AV27simpleEs = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "&PreliqEstado ", "")+GXutil.trim( GXutil.str( AV140PreliqEstado, 1, 0))) ;
         AV67DLiqPerAno = (short)(GXutil.year( AV114LiqPeriodo)) ;
         GXt_char2 = AV143quincenaTLiqCod ;
         GXt_char1 = AV143quincenaTLiqCod ;
         GXv_char4[0] = GXt_char1 ;
         new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         genconcepporlegajo7.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV38CliCod, GXt_char1, GXv_char3) ;
         genconcepporlegajo7.this.GXt_char2 = GXv_char3[0] ;
         AV143quincenaTLiqCod = GXt_char2 ;
         if ( ( GXutil.strcmp(AV11accionPalabra, httpContext.getMessage( "PRELIQUIDACION", "")) == 0 ) || ( AV140PreliqEstado != 3 ) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "llama a excluirCondiciones &noVanConCodigo ", "")+AV129noVanConCodigo.toJSonString(false)) ;
            GXv_objcol_char14[0] = AV76excluirConCondicion ;
            GXv_objcol_char15[0] = AV129noVanConCodigo ;
            new web.excluircondiciones(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV112LiqNro, AV101LegNumero, AV114LiqPeriodo, AV116liquidacionSimple, true, false, GXv_objcol_char14, GXv_objcol_char15) ;
            AV76excluirConCondicion = GXv_objcol_char14[0] ;
            AV129noVanConCodigo = GXv_objcol_char15[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "!&excluirConCondicion ", "")+GXutil.trim( GXutil.str( AV76excluirConCondicion.size(), 9, 0))+" "+AV76excluirConCondicion.toJSonString(false)) ;
            if ( ( GXutil.strcmp(AV174TLiqCod, AV120mensualTLiqCod) == 0 ) || ( GXutil.strcmp(AV174TLiqCod, AV143quincenaTLiqCod) == 0 ) )
            {
               GXv_boolean11[0] = AV86hayAlgunaCondicionComplejaIncluida ;
               GXv_char4[0] = AV183complejaCondicionDescrip ;
               new web.hayalgunacondicioncomplejaincluida(remoteHandle, context).execute( AV136paicod, AV76excluirConCondicion, GXv_boolean11, GXv_char4) ;
               genconcepporlegajo7.this.AV86hayAlgunaCondicionComplejaIncluida = GXv_boolean11[0] ;
               genconcepporlegajo7.this.AV183complejaCondicionDescrip = GXv_char4[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "&excluirConCondicion ", "")+GXutil.trim( GXutil.str( AV76excluirConCondicion.size(), 9, 0))+httpContext.getMessage( " &&exclusionesComplejas ", "")+GXutil.trim( GXutil.str( AV77exclusionesComplejas, 4, 0))+httpContext.getMessage( " &hayAlgunaCondicionComplejaIncluida ", "")+GXutil.trim( GXutil.booltostr( AV86hayAlgunaCondicionComplejaIncluida))) ;
               if ( ! AV86hayAlgunaCondicionComplejaIncluida )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "simple 1", "")) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "simple 2", "")) ;
                  GXv_boolean11[0] = AV135otraTiene ;
                  new web.tieneotraliquidacionenperiodo(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV112LiqNro, AV101LegNumero, AV114LiqPeriodo, AV127nadaTLiqCod, GXv_boolean11) ;
                  genconcepporlegajo7.this.AV135otraTiene = GXv_boolean11[0] ;
                  if ( ! AV135otraTiene )
                  {
                     if ( AV32cant_basica == AV63dias_trabajados )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "simple 4", "")) ;
                        AV27simpleEs = true ;
                     }
                     else
                     {
                        AV181basicaLiqDescrip += httpContext.getMessage( "Cantidad inicial de días trabajados ", "") + GXutil.trim( GXutil.str( AV32cant_basica, 4, 0)) + httpContext.getMessage( " es distinta a cantidad de días trabajados ", "") + GXutil.trim( GXutil.str( AV63dias_trabajados, 4, 0)) ;
                     }
                  }
                  else
                  {
                     AV181basicaLiqDescrip += httpContext.getMessage( "Tiene otra liquidación en periodo", "") ;
                  }
               }
               else
               {
                  AV181basicaLiqDescrip += httpContext.getMessage( "Condición compleja incluída ", "") + GXutil.trim( AV183complejaCondicionDescrip) ;
               }
            }
            else
            {
               AV181basicaLiqDescrip += httpContext.getMessage( "Tipo de liquidación no es mensual ni quincena", "") ;
            }
         }
         if ( ! AV27simpleEs )
         {
            GXv_char4[0] = AV24auxConCodigo ;
            GXv_char3[0] = "" ;
            new web.conceptosobregiro(remoteHandle, context).execute( AV38CliCod, GXv_char4, GXv_char3) ;
            genconcepporlegajo7.this.AV24auxConCodigo = GXv_char4[0] ;
            AV129noVanConCodigo.add(GXutil.trim( AV24auxConCodigo), 0);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "&accionPalabra ", "")+AV11accionPalabra) ;
         if ( AV27simpleEs )
         {
            AV181basicaLiqDescrip = httpContext.getMessage( ". modo básico", "") ;
         }
         GXt_dtime12 = AV39comienzo ;
         GXv_dtime13[0] = GXt_dtime12 ;
         new web.getahora(remoteHandle, context).execute( AV38CliCod, GXv_dtime13) ;
         genconcepporlegajo7.this.GXt_dtime12 = GXv_dtime13[0] ;
         AV39comienzo = GXt_dtime12 ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "&PreliqEstado ", "")+GXutil.trim( GXutil.str( AV140PreliqEstado, 1, 0))+httpContext.getMessage( " &noVanConCodigo ", "")+AV129noVanConCodigo.toJSonString(false)) ;
         new web.insert_into_select(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV114LiqPeriodo, AV174TLiqCod, AV112LiqNro, AV67DLiqPerAno, AV101LegNumero, AV76excluirConCondicion, AV129noVanConCodigo, AV27simpleEs, AV108LiqDSecuencial, AV136paicod, GXutil.trim( AV8ConveCodigo)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "&simpleEs = ", "")+GXutil.trim( GXutil.booltostr( AV27simpleEs))) ;
         if ( AV27simpleEs )
         {
            GXv_char4[0] = AV184redondeoConCodigo ;
            new web.getparametro(remoteHandle, context).execute( AV38CliCod, new web.concepto_redondeo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
            genconcepporlegajo7.this.AV184redondeoConCodigo = GXv_char4[0] ;
            /* Using cursor P02CK4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV71EmpCod), Integer.valueOf(AV112LiqNro), Integer.valueOf(AV101LegNumero), AV184redondeoConCodigo});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A394DConCodigo = P02CK4_A394DConCodigo[0] ;
               A6LegNumero = P02CK4_A6LegNumero[0] ;
               A31LiqNro = P02CK4_A31LiqNro[0] ;
               A1EmpCod = P02CK4_A1EmpCod[0] ;
               A3CliCod = P02CK4_A3CliCod[0] ;
               A81LiqDSecuencial = P02CK4_A81LiqDSecuencial[0] ;
               AV185redondeoHay = true ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               pr_default.readNext(2);
            }
            pr_default.close(2);
         }
         GXt_char2 = AV192calculo_TipoConCod ;
         GXv_char4[0] = GXt_char2 ;
         new web.gettipoconcepto(remoteHandle, context).execute( AV136paicod, "CAL", GXv_char4) ;
         genconcepporlegajo7.this.GXt_char2 = GXv_char4[0] ;
         AV192calculo_TipoConCod = GXt_char2 ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "&calculo_TipoConCod ", "")+AV192calculo_TipoConCod) ;
         AV205GXLvl295 = (byte)(0) ;
         /* Using cursor P02CK5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV71EmpCod), Integer.valueOf(AV112LiqNro), Integer.valueOf(AV101LegNumero), AV192calculo_TipoConCod});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A464DTipoConCod = P02CK5_A464DTipoConCod[0] ;
            A6LegNumero = P02CK5_A6LegNumero[0] ;
            A31LiqNro = P02CK5_A31LiqNro[0] ;
            A1EmpCod = P02CK5_A1EmpCod[0] ;
            A3CliCod = P02CK5_A3CliCod[0] ;
            A81LiqDSecuencial = P02CK5_A81LiqDSecuencial[0] ;
            AV205GXLvl295 = (byte)(1) ;
            AV187liq_nivel_complejidad = (byte)(3) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( AV205GXLvl295 == 0 )
         {
            AV187liq_nivel_complejidad = (byte)(2) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "none calculos", "")) ;
         }
         if ( AV187liq_nivel_complejidad == 3 )
         {
            GXt_char2 = AV193gananciasSubTipoConCod1 ;
            GXv_char4[0] = GXt_char2 ;
            new web.subtipocalculoganancias(remoteHandle, context).execute( GXv_char4) ;
            genconcepporlegajo7.this.GXt_char2 = GXv_char4[0] ;
            AV193gananciasSubTipoConCod1 = GXt_char2 ;
            /* Using cursor P02CK6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV71EmpCod), Integer.valueOf(AV112LiqNro), Integer.valueOf(AV101LegNumero), AV193gananciasSubTipoConCod1, AV192calculo_TipoConCod});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A468DSubTipoConCod1 = P02CK6_A468DSubTipoConCod1[0] ;
               n468DSubTipoConCod1 = P02CK6_n468DSubTipoConCod1[0] ;
               A464DTipoConCod = P02CK6_A464DTipoConCod[0] ;
               A6LegNumero = P02CK6_A6LegNumero[0] ;
               A31LiqNro = P02CK6_A31LiqNro[0] ;
               A1EmpCod = P02CK6_A1EmpCod[0] ;
               A3CliCod = P02CK6_A3CliCod[0] ;
               A81LiqDSecuencial = P02CK6_A81LiqDSecuencial[0] ;
               AV187liq_nivel_complejidad = (byte)(4) ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               pr_default.readNext(4);
            }
            pr_default.close(4);
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "&liq_nivel_complejidad ", "")+GXutil.str( AV187liq_nivel_complejidad, 1, 0)) ;
      /* Optimized UPDATE. */
      /* Using cursor P02CK7 */
      pr_default.execute(5, new Object[] {Byte.valueOf(AV187liq_nivel_complejidad), Integer.valueOf(AV38CliCod), Short.valueOf(AV71EmpCod), Integer.valueOf(AV112LiqNro), Integer.valueOf(AV101LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
      /* End optimized UPDATE. */
      GXv_char4[0] = AV10parmValue ;
      new web.getparametro(remoteHandle, context).execute( AV38CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
      genconcepporlegajo7.this.AV10parmValue = GXv_char4[0] ;
      AV123modoTestEs = GXutil.boolval( AV10parmValue) ;
      if ( AV123modoTestEs )
      {
         /* Using cursor P02CK8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV71EmpCod), Integer.valueOf(AV112LiqNro), Integer.valueOf(AV101LegNumero)});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A6LegNumero = P02CK8_A6LegNumero[0] ;
            A31LiqNro = P02CK8_A31LiqNro[0] ;
            A1EmpCod = P02CK8_A1EmpCod[0] ;
            A3CliCod = P02CK8_A3CliCod[0] ;
            A394DConCodigo = P02CK8_A394DConCodigo[0] ;
            A81LiqDSecuencial = P02CK8_A81LiqDSecuencial[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "DConCodigo ", "")+A394DConCodigo) ;
            pr_default.readNext(6);
         }
         pr_default.close(6);
      }
      GXt_dtime12 = AV19ahora ;
      GXv_dtime13[0] = GXt_dtime12 ;
      new web.getahora(remoteHandle, context).execute( AV38CliCod, GXv_dtime13) ;
      genconcepporlegajo7.this.GXt_dtime12 = GXv_dtime13[0] ;
      AV19ahora = GXt_dtime12 ;
      AV157segundos = DecimalUtil.doubleToDec(GXutil.dtdiffms( AV19ahora, AV39comienzo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, httpContext.getMessage( "insert into select segundos ", "")+GXutil.trim( GXutil.str( AV157segundos, 6, 4))) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'APLICACIERTASLIQUIDACIONES' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, "---21 "+AV48ConCodigo) ;
      GXv_boolean11[0] = AV113LiqOK ;
      new web.conceptoaplicatipoliqyconvenio(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV112LiqNro, AV101LegNumero, AV48ConCodigo, AV174TLiqCod, AV8ConveCodigo, GXv_boolean11) ;
      genconcepporlegajo7.this.AV113LiqOK = GXv_boolean11[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV201Pgmname, "---22 "+AV48ConCodigo+httpContext.getMessage( " &LiqOK ", "")+GXutil.trim( GXutil.booltostr( AV113LiqOK))) ;
   }

   public void S121( )
   {
      /* 'AGREGAR DETALLE' Routine */
      returnInSub = false ;
      AV149retroOK = true ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "&ConFormula ", "")+GXutil.trim( AV53ConFormula)+httpContext.getMessage( " retropalabra ", "")+AV150retroPalabra) ;
      if ( GXutil.strSearch( GXutil.upper( AV53ConFormula), GXutil.trim( GXutil.upper( AV150retroPalabra)), 1) != 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "es novedadretro", "")) ;
         GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem16[0] = AV155sdt_liq_retroactivas ;
         GXv_char4[0] = AV131novedadRetroError ;
         new web.procesarformulaconretro(remoteHandle, context).execute( AV38CliCod, AV136paicod, AV174TLiqCod, AV114LiqPeriodo, "{retroactivo}", AV48ConCodigo, AV53ConFormula, AV150retroPalabra, true, false, GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem16, GXv_char4) ;
         AV155sdt_liq_retroactivas = GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem16[0] ;
         genconcepporlegajo7.this.AV131novedadRetroError = GXv_char4[0] ;
         if ( ! (GXutil.strcmp("", AV131novedadRetroError)==0) )
         {
            AV131novedadRetroError = httpContext.getMessage( "Error al procesar fórmula retroactiva: ", "") + GXutil.trim( AV131novedadRetroError) ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "&novedadRetroError ", "")+AV131novedadRetroError) ;
         if ( ! (GXutil.strcmp("", AV131novedadRetroError)==0) )
         {
            new web.setliqlegerror(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV112LiqNro, AV101LegNumero, AV131novedadRetroError) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, AV131novedadRetroError) ;
            AV46conceptosOK = false ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "detectó y se va", "")) ;
            returnInSub = true;
            if (true) return;
         }
      }
      if ( AV149retroOK )
      {
         AV108LiqDSecuencial = (int)(AV108LiqDSecuencial+1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "agenda NewLiquidacionDetalle &AgeImporte ", "")+GXutil.trim( GXutil.str( AV15AgeImporte, 14, 2))) ;
         if ( GXutil.strcmp(AV11accionPalabra, httpContext.getMessage( "PRELIQUIDACION", "")) != 0 )
         {
            GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean11[0] = AV59dependenciasResueltas ;
            GXv_char4[0] = AV53ConFormula ;
            GXv_char3[0] = AV74error ;
            new web.newliquidaciondetalle3(remoteHandle, context).execute( AV38CliCod, AV71EmpCod, AV112LiqNro, AV115LiqRelNro, AV101LegNumero, AV48ConCodigo, AV146resolver, AV108LiqDSecuencial, AV15AgeImporte, AV14AgeCanti, AV16AgeVUnit, AV194AgeFecDes, AV198AgeFecHas, AV15AgeImporte, false, AV124Mostrarconcepto, AV114LiqPeriodo, AV174TLiqCod, true, AV107LiqDLote, false, "", GXv_decimal10, GXv_boolean11, GXv_char4, GXv_char3) ;
            genconcepporlegajo7.this.AV59dependenciasResueltas = GXv_boolean11[0] ;
            genconcepporlegajo7.this.AV53ConFormula = GXv_char4[0] ;
            genconcepporlegajo7.this.AV74error = GXv_char3[0] ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "&concodigo ", "")+GXutil.trim( AV48ConCodigo)+httpContext.getMessage( " &ConPueNov ", "")+GXutil.trim( GXutil.booltostr( AV195ConPueNov))) ;
         if ( AV195ConPueNov )
         {
            AV129noVanConCodigo.add(AV196nConCodigo, 0);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV38CliCod, AV201Pgmname, httpContext.getMessage( "no simple 1", "")) ;
         }
         if ( ! (GXutil.strcmp("", AV74error)==0) && ( AV59dependenciasResueltas ) )
         {
            AV46conceptosOK = false ;
            returnInSub = true;
            if (true) return;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP12[0] = genconcepporlegajo7.this.AV110LiqLog;
      this.aP13[0] = genconcepporlegajo7.this.AV108LiqDSecuencial;
      this.aP14[0] = genconcepporlegajo7.this.AV46conceptosOK;
      this.aP15[0] = genconcepporlegajo7.this.AV76excluirConCondicion;
      this.aP16[0] = genconcepporlegajo7.this.AV129noVanConCodigo;
      this.aP17[0] = genconcepporlegajo7.this.AV187liq_nivel_complejidad;
      this.aP18[0] = genconcepporlegajo7.this.AV185redondeoHay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV110LiqLog = "" ;
      AV76excluirConCondicion = new GXSimpleCollection<String>(String.class, "internal", "");
      AV129noVanConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV201Pgmname = "" ;
      AV109LiqFecha = GXutil.nullDate() ;
      AV120mensualTLiqCod = "" ;
      AV10parmValue = "" ;
      AV143quincenaTLiqCod = "" ;
      AV70egresoTLiqCod = "" ;
      AV98LegFecIngreso = GXutil.nullDate() ;
      AV97LegFecEgreso = GXutil.nullDate() ;
      GXv_int5 = new byte[1] ;
      GXv_int8 = new short[1] ;
      AV189tipo_sueldo = "" ;
      AV184redondeoConCodigo = "" ;
      GXv_int9 = new short[1] ;
      AV41comienzo3 = GXutil.resetTime( GXutil.nullDate() );
      AV141primerDiaPeriodo = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      AV176ultimoDiaPeriodo = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV130novedadConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22appendLiqLog = "" ;
      AV42comienzo4 = GXutil.resetTime( GXutil.nullDate() );
      AV150retroPalabra = "" ;
      scmdbuf = "" ;
      A111AgeFecDes = GXutil.nullDate() ;
      A112AgeFecHas = GXutil.nullDate() ;
      P02CK2_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CK2_n113AgeImporte = new boolean[] {false} ;
      P02CK2_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CK2_n110AgeCanti = new boolean[] {false} ;
      P02CK2_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CK2_n115AgeVUnit = new boolean[] {false} ;
      P02CK2_A148ConFormula = new String[] {""} ;
      P02CK2_n148ConFormula = new boolean[] {false} ;
      P02CK2_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P02CK2_n112AgeFecHas = new boolean[] {false} ;
      P02CK2_A1826ConPueNov = new boolean[] {false} ;
      P02CK2_A1254AgeLiqNro = new int[1] ;
      P02CK2_n1254AgeLiqNro = new boolean[] {false} ;
      P02CK2_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P02CK2_n111AgeFecDes = new boolean[] {false} ;
      P02CK2_A26ConCodigo = new String[] {""} ;
      P02CK2_A6LegNumero = new int[1] ;
      P02CK2_A1EmpCod = new short[1] ;
      P02CK2_A3CliCod = new int[1] ;
      P02CK2_A150ConHabilitado = new boolean[] {false} ;
      P02CK2_A25AgeOrden = new short[1] ;
      A113AgeImporte = DecimalUtil.ZERO ;
      A110AgeCanti = DecimalUtil.ZERO ;
      A115AgeVUnit = DecimalUtil.ZERO ;
      A148ConFormula = "" ;
      A26ConCodigo = "" ;
      AV48ConCodigo = "" ;
      AV15AgeImporte = DecimalUtil.ZERO ;
      AV14AgeCanti = DecimalUtil.ZERO ;
      AV16AgeVUnit = DecimalUtil.ZERO ;
      AV53ConFormula = "" ;
      AV194AgeFecDes = GXutil.nullDate() ;
      AV198AgeFecHas = GXutil.nullDate() ;
      GXt_char1 = "" ;
      GXv_objcol_char14 = new GXSimpleCollection[1] ;
      GXv_objcol_char15 = new GXSimpleCollection[1] ;
      AV183complejaCondicionDescrip = "" ;
      AV127nadaTLiqCod = "" ;
      AV181basicaLiqDescrip = "" ;
      AV24auxConCodigo = "" ;
      AV39comienzo = GXutil.resetTime( GXutil.nullDate() );
      P02CK4_A394DConCodigo = new String[] {""} ;
      P02CK4_A6LegNumero = new int[1] ;
      P02CK4_A31LiqNro = new int[1] ;
      P02CK4_A1EmpCod = new short[1] ;
      P02CK4_A3CliCod = new int[1] ;
      P02CK4_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      AV192calculo_TipoConCod = "" ;
      P02CK5_A464DTipoConCod = new String[] {""} ;
      P02CK5_A6LegNumero = new int[1] ;
      P02CK5_A31LiqNro = new int[1] ;
      P02CK5_A1EmpCod = new short[1] ;
      P02CK5_A3CliCod = new int[1] ;
      P02CK5_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      AV193gananciasSubTipoConCod1 = "" ;
      GXt_char2 = "" ;
      P02CK6_A468DSubTipoConCod1 = new String[] {""} ;
      P02CK6_n468DSubTipoConCod1 = new boolean[] {false} ;
      P02CK6_A464DTipoConCod = new String[] {""} ;
      P02CK6_A6LegNumero = new int[1] ;
      P02CK6_A31LiqNro = new int[1] ;
      P02CK6_A1EmpCod = new short[1] ;
      P02CK6_A3CliCod = new int[1] ;
      P02CK6_A81LiqDSecuencial = new int[1] ;
      A468DSubTipoConCod1 = "" ;
      P02CK8_A6LegNumero = new int[1] ;
      P02CK8_A31LiqNro = new int[1] ;
      P02CK8_A1EmpCod = new short[1] ;
      P02CK8_A3CliCod = new int[1] ;
      P02CK8_A394DConCodigo = new String[] {""} ;
      P02CK8_A81LiqDSecuencial = new int[1] ;
      AV19ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime12 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime13 = new java.util.Date[1] ;
      AV157segundos = DecimalUtil.ZERO ;
      AV155sdt_liq_retroactivas = new GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem>(web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem.class, "sdt_liq_retroactivasItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem16 = new GXBaseCollection[1] ;
      AV131novedadRetroError = "" ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      AV74error = "" ;
      GXv_char3 = new String[1] ;
      AV196nConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.genconcepporlegajo7__default(),
         new Object[] {
             new Object[] {
            P02CK2_A113AgeImporte, P02CK2_n113AgeImporte, P02CK2_A110AgeCanti, P02CK2_n110AgeCanti, P02CK2_A115AgeVUnit, P02CK2_n115AgeVUnit, P02CK2_A148ConFormula, P02CK2_n148ConFormula, P02CK2_A112AgeFecHas, P02CK2_n112AgeFecHas,
            P02CK2_A1826ConPueNov, P02CK2_A1254AgeLiqNro, P02CK2_n1254AgeLiqNro, P02CK2_A111AgeFecDes, P02CK2_n111AgeFecDes, P02CK2_A26ConCodigo, P02CK2_A6LegNumero, P02CK2_A1EmpCod, P02CK2_A3CliCod, P02CK2_A150ConHabilitado,
            P02CK2_A25AgeOrden
            }
            , new Object[] {
            }
            , new Object[] {
            P02CK4_A394DConCodigo, P02CK4_A6LegNumero, P02CK4_A31LiqNro, P02CK4_A1EmpCod, P02CK4_A3CliCod, P02CK4_A81LiqDSecuencial
            }
            , new Object[] {
            P02CK5_A464DTipoConCod, P02CK5_A6LegNumero, P02CK5_A31LiqNro, P02CK5_A1EmpCod, P02CK5_A3CliCod, P02CK5_A81LiqDSecuencial
            }
            , new Object[] {
            P02CK6_A468DSubTipoConCod1, P02CK6_n468DSubTipoConCod1, P02CK6_A464DTipoConCod, P02CK6_A6LegNumero, P02CK6_A31LiqNro, P02CK6_A1EmpCod, P02CK6_A3CliCod, P02CK6_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            P02CK8_A6LegNumero, P02CK8_A31LiqNro, P02CK8_A1EmpCod, P02CK8_A3CliCod, P02CK8_A394DConCodigo, P02CK8_A81LiqDSecuencial
            }
         }
      );
      AV201Pgmname = "GenConcepPorLegajo7" ;
      /* GeneXus formulas. */
      AV201Pgmname = "GenConcepPorLegajo7" ;
      Gx_err = (short)(0) ;
   }

   private byte AV187liq_nivel_complejidad ;
   private byte AV9LegClase ;
   private byte AV72EmpTipoExp ;
   private byte GXv_int5[] ;
   private byte AV107LiqDLote ;
   private byte AV124Mostrarconcepto ;
   private byte AV140PreliqEstado ;
   private byte AV205GXLvl295 ;
   private byte A2360LiqLegNivLiq ;
   private short AV71EmpCod ;
   private short AV63dias_trabajados ;
   private short GXv_int8[] ;
   private short AV32cant_basica ;
   private short AV190LegSuelSec ;
   private short AV136paicod ;
   private short GXv_int9[] ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short AV67DLiqPerAno ;
   private short AV77exclusionesComplejas ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int AV112LiqNro ;
   private int AV101LegNumero ;
   private int AV177ultimoLiqDSecuencial ;
   private int AV115LiqRelNro ;
   private int AV108LiqDSecuencial ;
   private int A1254AgeLiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal A113AgeImporte ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal A115AgeVUnit ;
   private java.math.BigDecimal AV15AgeImporte ;
   private java.math.BigDecimal AV14AgeCanti ;
   private java.math.BigDecimal AV16AgeVUnit ;
   private java.math.BigDecimal AV157segundos ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private String AV174TLiqCod ;
   private String AV8ConveCodigo ;
   private String AV11accionPalabra ;
   private String AV201Pgmname ;
   private String AV120mensualTLiqCod ;
   private String AV143quincenaTLiqCod ;
   private String AV70egresoTLiqCod ;
   private String AV189tipo_sueldo ;
   private String AV184redondeoConCodigo ;
   private String AV150retroPalabra ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV48ConCodigo ;
   private String GXt_char1 ;
   private String AV127nadaTLiqCod ;
   private String AV24auxConCodigo ;
   private String A394DConCodigo ;
   private String AV192calculo_TipoConCod ;
   private String A464DTipoConCod ;
   private String AV193gananciasSubTipoConCod1 ;
   private String GXt_char2 ;
   private String A468DSubTipoConCod1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String AV196nConCodigo ;
   private java.util.Date AV41comienzo3 ;
   private java.util.Date AV42comienzo4 ;
   private java.util.Date AV39comienzo ;
   private java.util.Date AV19ahora ;
   private java.util.Date GXt_dtime12 ;
   private java.util.Date GXv_dtime13[] ;
   private java.util.Date AV114LiqPeriodo ;
   private java.util.Date AV109LiqFecha ;
   private java.util.Date AV98LegFecIngreso ;
   private java.util.Date AV97LegFecEgreso ;
   private java.util.Date AV141primerDiaPeriodo ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date AV176ultimoDiaPeriodo ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date A112AgeFecHas ;
   private java.util.Date AV194AgeFecDes ;
   private java.util.Date AV198AgeFecHas ;
   private boolean AV146resolver ;
   private boolean AV186LiqSac ;
   private boolean AV46conceptosOK ;
   private boolean AV185redondeoHay ;
   private boolean AV197desglosar_HorTraYAdiPorDia ;
   private boolean AV175todosLosMeses30 ;
   private boolean AV191LegSuelBasica ;
   private boolean A150ConHabilitado ;
   private boolean brk2CK2 ;
   private boolean n113AgeImporte ;
   private boolean n110AgeCanti ;
   private boolean n115AgeVUnit ;
   private boolean n148ConFormula ;
   private boolean n112AgeFecHas ;
   private boolean A1826ConPueNov ;
   private boolean n1254AgeLiqNro ;
   private boolean n111AgeFecDes ;
   private boolean returnInSub ;
   private boolean AV113LiqOK ;
   private boolean AV75estaEnLiqAntDelPeriodo ;
   private boolean AV195ConPueNov ;
   private boolean AV116liquidacionSimple ;
   private boolean AV27simpleEs ;
   private boolean AV86hayAlgunaCondicionComplejaIncluida ;
   private boolean AV135otraTiene ;
   private boolean n468DSubTipoConCod1 ;
   private boolean AV123modoTestEs ;
   private boolean AV149retroOK ;
   private boolean AV59dependenciasResueltas ;
   private boolean GXv_boolean11[] ;
   private String AV110LiqLog ;
   private String AV10parmValue ;
   private String AV22appendLiqLog ;
   private String A148ConFormula ;
   private String AV53ConFormula ;
   private String AV183complejaCondicionDescrip ;
   private String AV181basicaLiqDescrip ;
   private String AV131novedadRetroError ;
   private String AV74error ;
   private boolean[] aP18 ;
   private String[] aP12 ;
   private int[] aP13 ;
   private boolean[] aP14 ;
   private GXSimpleCollection<String>[] aP15 ;
   private GXSimpleCollection<String>[] aP16 ;
   private byte[] aP17 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P02CK2_A113AgeImporte ;
   private boolean[] P02CK2_n113AgeImporte ;
   private java.math.BigDecimal[] P02CK2_A110AgeCanti ;
   private boolean[] P02CK2_n110AgeCanti ;
   private java.math.BigDecimal[] P02CK2_A115AgeVUnit ;
   private boolean[] P02CK2_n115AgeVUnit ;
   private String[] P02CK2_A148ConFormula ;
   private boolean[] P02CK2_n148ConFormula ;
   private java.util.Date[] P02CK2_A112AgeFecHas ;
   private boolean[] P02CK2_n112AgeFecHas ;
   private boolean[] P02CK2_A1826ConPueNov ;
   private int[] P02CK2_A1254AgeLiqNro ;
   private boolean[] P02CK2_n1254AgeLiqNro ;
   private java.util.Date[] P02CK2_A111AgeFecDes ;
   private boolean[] P02CK2_n111AgeFecDes ;
   private String[] P02CK2_A26ConCodigo ;
   private int[] P02CK2_A6LegNumero ;
   private short[] P02CK2_A1EmpCod ;
   private int[] P02CK2_A3CliCod ;
   private boolean[] P02CK2_A150ConHabilitado ;
   private short[] P02CK2_A25AgeOrden ;
   private String[] P02CK4_A394DConCodigo ;
   private int[] P02CK4_A6LegNumero ;
   private int[] P02CK4_A31LiqNro ;
   private short[] P02CK4_A1EmpCod ;
   private int[] P02CK4_A3CliCod ;
   private int[] P02CK4_A81LiqDSecuencial ;
   private String[] P02CK5_A464DTipoConCod ;
   private int[] P02CK5_A6LegNumero ;
   private int[] P02CK5_A31LiqNro ;
   private short[] P02CK5_A1EmpCod ;
   private int[] P02CK5_A3CliCod ;
   private int[] P02CK5_A81LiqDSecuencial ;
   private String[] P02CK6_A468DSubTipoConCod1 ;
   private boolean[] P02CK6_n468DSubTipoConCod1 ;
   private String[] P02CK6_A464DTipoConCod ;
   private int[] P02CK6_A6LegNumero ;
   private int[] P02CK6_A31LiqNro ;
   private short[] P02CK6_A1EmpCod ;
   private int[] P02CK6_A3CliCod ;
   private int[] P02CK6_A81LiqDSecuencial ;
   private int[] P02CK8_A6LegNumero ;
   private int[] P02CK8_A31LiqNro ;
   private short[] P02CK8_A1EmpCod ;
   private int[] P02CK8_A3CliCod ;
   private String[] P02CK8_A394DConCodigo ;
   private int[] P02CK8_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV76excluirConCondicion ;
   private GXSimpleCollection<String> AV129noVanConCodigo ;
   private GXSimpleCollection<String> AV130novedadConCodigo ;
   private GXSimpleCollection<String> GXv_objcol_char14[] ;
   private GXSimpleCollection<String> GXv_objcol_char15[] ;
   private GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem> AV155sdt_liq_retroactivas ;
   private GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem> GXv_objcol_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem16[] ;
}

final  class genconcepporlegajo7__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02CK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV115LiqRelNro ,
                                          int A1254AgeLiqNro ,
                                          java.util.Date A111AgeFecDes ,
                                          java.util.Date AV176ultimoDiaPeriodo ,
                                          java.util.Date A112AgeFecHas ,
                                          java.util.Date AV141primerDiaPeriodo ,
                                          boolean A150ConHabilitado ,
                                          int AV38CliCod ,
                                          short AV71EmpCod ,
                                          int AV101LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[5];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT T1.AgeImporte, T1.AgeCanti, T1.AgeVUnit, T2.ConFormula, T1.AgeFecHas, T2.ConPueNov, T1.AgeLiqNro, T1.AgeFecDes, T1.ConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod," ;
      scmdbuf += " T2.ConHabilitado, T1.AgeOrden FROM (AgendaNovedades T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T1.AgeFecDes <= ?)");
      addWhere(sWhereString, "(T1.AgeFecHas >= ? or (T1.AgeFecHas = DATE '00010101') or T1.AgeFecHas IS NULL)");
      addWhere(sWhereString, "(T2.ConHabilitado = TRUE)");
      if ( (0==AV115LiqRelNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.ConCodigo, T1.AgeFecDes" ;
      scmdbuf += " FOR UPDATE OF T1, T1" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
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
                  return conditional_P02CK2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , ((Boolean) dynConstraints[6]).booleanValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CK2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02CK3", "SAVEPOINT gxupdate;UPDATE AgendaNovedades SET AgeLiqNro=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02CK4", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02CK5", "SELECT DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02CK6", "SELECT DSubTipoConCod1, DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DSubTipoConCod1 = ( ?)) AND (DTipoConCod = ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DSubTipoConCod1  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02CK7", "UPDATE LiquidacionLegajo SET LiqLegNivLiq=?  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02CK8", "SELECT LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((boolean[]) buf[10])[0] = rslt.getBoolean(6);
               ((int[]) buf[11])[0] = rslt.getInt(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(9, 10);
               ((int[]) buf[16])[0] = rslt.getInt(10);
               ((short[]) buf[17])[0] = rslt.getShort(11);
               ((int[]) buf[18])[0] = rslt.getInt(12);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((short[]) buf[20])[0] = rslt.getShort(14);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[8]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setShort(3, ((Number) parms[3]).shortValue());
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 5 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

