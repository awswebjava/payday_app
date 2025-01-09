package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabanovedadconcepto extends GXProcedure
{
   public grabanovedadconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabanovedadconcepto.class ), "" );
   }

   public grabanovedadconcepto( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 ,
                                                 int aP2 ,
                                                 String aP3 ,
                                                 byte aP4 ,
                                                 java.math.BigDecimal aP5 ,
                                                 java.math.BigDecimal aP6 ,
                                                 byte aP7 ,
                                                 String aP8 ,
                                                 byte aP9 ,
                                                 java.util.Date aP10 ,
                                                 java.util.Date aP11 ,
                                                 boolean aP12 ,
                                                 boolean aP13 )
   {
      grabanovedadconcepto.this.aP14 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        byte aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.math.BigDecimal aP6 ,
                        byte aP7 ,
                        String aP8 ,
                        byte aP9 ,
                        java.util.Date aP10 ,
                        java.util.Date aP11 ,
                        boolean aP12 ,
                        boolean aP13 ,
                        GXSimpleCollection<String>[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             byte aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.math.BigDecimal aP6 ,
                             byte aP7 ,
                             String aP8 ,
                             byte aP9 ,
                             java.util.Date aP10 ,
                             java.util.Date aP11 ,
                             boolean aP12 ,
                             boolean aP13 ,
                             GXSimpleCollection<String>[] aP14 )
   {
      grabanovedadconcepto.this.AV9CliCod = aP0;
      grabanovedadconcepto.this.AV10EmpCod = aP1;
      grabanovedadconcepto.this.AV11LegNumero = aP2;
      grabanovedadconcepto.this.AV12ConCodigo = aP3;
      grabanovedadconcepto.this.AV38dia = aP4;
      grabanovedadconcepto.this.AV13AgeCanti = aP5;
      grabanovedadconcepto.this.AV14AgeImporte = aP6;
      grabanovedadconcepto.this.AV20LegClase = aP7;
      grabanovedadconcepto.this.AV43LegModTra = aP8;
      grabanovedadconcepto.this.AV8Metodo = aP9;
      grabanovedadconcepto.this.AV22DesdeFecha = aP10;
      grabanovedadconcepto.this.AV23HastaFecha = aP11;
      grabanovedadconcepto.this.AV24primeraQuincena = aP12;
      grabanovedadconcepto.this.AV25segundaQuincena = aP13;
      grabanovedadconcepto.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, "1") ;
      AV31c = (short)(1) ;
      while ( AV31c <= 2 )
      {
         if ( AV31c == 1 )
         {
            AV26controlar = true ;
         }
         else
         {
            AV26controlar = false ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "2 &controlar ", "")+GXutil.trim( GXutil.booltostr( AV26controlar))+httpContext.getMessage( " &Metodo ", "")+GXutil.trim( GXutil.str( AV8Metodo, 1, 0))+httpContext.getMessage( " &dia ", "")+GXutil.trim( GXutil.str( AV38dia, 2, 0))) ;
         if ( ( AV8Metodo == 1 ) || ! (0==AV38dia) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, "3") ;
            GXt_int1 = AV17AgeOrden ;
            GXv_int2[0] = GXt_int1 ;
            new web.getnextorden(remoteHandle, context).execute( AV10EmpCod, AV11LegNumero, GXv_int2) ;
            grabanovedadconcepto.this.GXt_int1 = GXv_int2[0] ;
            AV17AgeOrden = GXt_int1 ;
            AV15AgeFecDes = AV22DesdeFecha ;
            AV16AgeFecHas = AV23HastaFecha ;
            GXt_char3 = AV35TLiqCod ;
            GXt_char4 = AV35TLiqCod ;
            GXv_char5[0] = GXt_char4 ;
            new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char5) ;
            grabanovedadconcepto.this.GXt_char4 = GXv_char5[0] ;
            GXv_char6[0] = GXt_char3 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char4, GXv_char6) ;
            grabanovedadconcepto.this.GXt_char3 = GXv_char6[0] ;
            AV35TLiqCod = GXt_char3 ;
            /* Execute user subroutine: 'ALTA REGISTRO' */
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
            if ( AV20LegClase != 1 )
            {
               if ( ( AV24primeraQuincena ) || ( AV25segundaQuincena ) )
               {
                  if ( AV24primeraQuincena )
                  {
                     GXt_char4 = AV35TLiqCod ;
                     GXt_char3 = AV35TLiqCod ;
                     GXv_char6[0] = GXt_char3 ;
                     new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                     grabanovedadconcepto.this.GXt_char3 = GXv_char6[0] ;
                     GXv_char5[0] = GXt_char4 ;
                     new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
                     grabanovedadconcepto.this.GXt_char4 = GXv_char5[0] ;
                     AV35TLiqCod = GXt_char4 ;
                  }
                  else
                  {
                     GXt_char4 = AV35TLiqCod ;
                     GXt_char3 = AV35TLiqCod ;
                     GXv_char6[0] = GXt_char3 ;
                     new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                     grabanovedadconcepto.this.GXt_char3 = GXv_char6[0] ;
                     GXv_char5[0] = GXt_char4 ;
                     new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
                     grabanovedadconcepto.this.GXt_char4 = GXv_char5[0] ;
                     AV35TLiqCod = GXt_char4 ;
                  }
                  AV21auxDesdeFecha = AV22DesdeFecha ;
                  while ( (( GXutil.resetTime(AV21auxDesdeFecha).before( GXutil.resetTime( AV23HastaFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV21auxDesdeFecha), GXutil.resetTime(AV23HastaFecha)) )) )
                  {
                     if ( AV24primeraQuincena )
                     {
                        GXt_int1 = AV17AgeOrden ;
                        GXv_int2[0] = GXt_int1 ;
                        new web.getnextorden(remoteHandle, context).execute( AV10EmpCod, AV11LegNumero, GXv_int2) ;
                        grabanovedadconcepto.this.GXt_int1 = GXv_int2[0] ;
                        AV17AgeOrden = GXt_int1 ;
                        GXv_date7[0] = AV15AgeFecDes ;
                        GXv_date8[0] = AV16AgeFecHas ;
                        new web.getperiodoquincena(remoteHandle, context).execute( AV9CliCod, (short)(1), AV21auxDesdeFecha, GXv_date7, GXv_date8) ;
                        grabanovedadconcepto.this.AV15AgeFecDes = GXv_date7[0] ;
                        grabanovedadconcepto.this.AV16AgeFecHas = GXv_date8[0] ;
                        /* Execute user subroutine: 'ALTA REGISTRO' */
                        S111 ();
                        if ( returnInSub )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                     if ( AV25segundaQuincena )
                     {
                        GXt_int1 = AV17AgeOrden ;
                        GXv_int2[0] = GXt_int1 ;
                        new web.getnextorden(remoteHandle, context).execute( AV10EmpCod, AV11LegNumero, GXv_int2) ;
                        grabanovedadconcepto.this.GXt_int1 = GXv_int2[0] ;
                        AV17AgeOrden = GXt_int1 ;
                        GXv_date8[0] = AV15AgeFecDes ;
                        GXv_date7[0] = AV16AgeFecHas ;
                        new web.getperiodoquincena(remoteHandle, context).execute( AV9CliCod, (short)(2), AV21auxDesdeFecha, GXv_date8, GXv_date7) ;
                        grabanovedadconcepto.this.AV15AgeFecDes = GXv_date8[0] ;
                        grabanovedadconcepto.this.AV16AgeFecHas = GXv_date7[0] ;
                        /* Execute user subroutine: 'ALTA REGISTRO' */
                        S111 ();
                        if ( returnInSub )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                     AV21auxDesdeFecha = GXutil.addmth( AV21auxDesdeFecha, (short)(1)) ;
                  }
               }
               else
               {
                  GXt_int1 = AV17AgeOrden ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getnextorden(remoteHandle, context).execute( AV10EmpCod, AV11LegNumero, GXv_int2) ;
                  grabanovedadconcepto.this.GXt_int1 = GXv_int2[0] ;
                  AV17AgeOrden = GXt_int1 ;
                  AV15AgeFecDes = AV22DesdeFecha ;
                  AV16AgeFecHas = GXutil.eomdate( AV23HastaFecha) ;
                  GXt_char4 = AV35TLiqCod ;
                  GXt_char3 = AV35TLiqCod ;
                  GXv_char6[0] = GXt_char3 ;
                  new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char6) ;
                  grabanovedadconcepto.this.GXt_char3 = GXv_char6[0] ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
                  grabanovedadconcepto.this.GXt_char4 = GXv_char5[0] ;
                  AV35TLiqCod = GXt_char4 ;
                  /* Execute user subroutine: 'ALTA REGISTRO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else
            {
               GXt_char4 = AV35TLiqCod ;
               GXt_char3 = AV35TLiqCod ;
               GXv_char6[0] = GXt_char3 ;
               new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char6) ;
               grabanovedadconcepto.this.GXt_char3 = GXv_char6[0] ;
               GXv_char5[0] = GXt_char4 ;
               new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char5) ;
               grabanovedadconcepto.this.GXt_char4 = GXv_char5[0] ;
               AV35TLiqCod = GXt_char4 ;
               AV21auxDesdeFecha = AV22DesdeFecha ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&auxDesdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV21auxDesdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &HastaFecha ", "")+GXutil.trim( localUtil.dtoc( AV23HastaFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               while ( (( GXutil.resetTime(AV21auxDesdeFecha).before( GXutil.resetTime( AV23HastaFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV21auxDesdeFecha), GXutil.resetTime(AV23HastaFecha)) )) )
               {
                  GXt_int1 = AV17AgeOrden ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getnextorden(remoteHandle, context).execute( AV10EmpCod, AV11LegNumero, GXv_int2) ;
                  grabanovedadconcepto.this.GXt_int1 = GXv_int2[0] ;
                  AV17AgeOrden = GXt_int1 ;
                  if ( GXutil.dateCompare(GXutil.resetTime(AV21auxDesdeFecha), GXutil.resetTime(AV22DesdeFecha)) )
                  {
                     AV15AgeFecDes = AV21auxDesdeFecha ;
                  }
                  else
                  {
                     AV15AgeFecDes = localUtil.ymdtod( GXutil.year( AV21auxDesdeFecha), GXutil.month( AV21auxDesdeFecha), 1) ;
                  }
                  if ( GXutil.month( AV21auxDesdeFecha) == GXutil.month( AV23HastaFecha) )
                  {
                     AV16AgeFecHas = GXutil.eomdate( AV23HastaFecha) ;
                  }
                  else
                  {
                     AV16AgeFecHas = GXutil.eomdate( AV21auxDesdeFecha) ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&AgeFecDes ", "")+GXutil.trim( localUtil.dtoc( AV15AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &AgeFecHas ", "")+GXutil.trim( localUtil.dtoc( AV16AgeFecHas, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &auxDesdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV21auxDesdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                  /* Execute user subroutine: 'ALTA REGISTRO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  AV21auxDesdeFecha = GXutil.addmth( AV21auxDesdeFecha, (short)(1)) ;
               }
            }
         }
         AV31c = (short)(AV31c+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ALTA REGISTRO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "3 &controlar ", "")+GXutil.trim( GXutil.booltostr( AV26controlar))+httpContext.getMessage( " &AgeFecHas ", "")+GXutil.trim( localUtil.dtoc( AV16AgeFecHas, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &AgeFecDes ", "")+GXutil.trim( localUtil.dtoc( AV15AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      if ( AV26controlar )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, "4") ;
         GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean12[0] = AV27existe ;
         new web.getagendavalorenrango(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, AV12ConCodigo, AV16AgeFecHas, AV15AgeFecDes, (short)(0), true, GXv_decimal9, GXv_decimal10, GXv_decimal11, GXv_boolean12) ;
         grabanovedadconcepto.this.AV27existe = GXv_boolean12[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "5 existe ", "")+GXutil.trim( GXutil.booltostr( AV27existe))) ;
         if ( AV27existe )
         {
            AV30errores.add(httpContext.getMessage( "Duplicación de novedad", ""), 0);
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "novedad duplicada", "")) ;
            returnInSub = true;
            if (true) return;
         }
         GXv_char6[0] = AV32SubTipoConCod1 ;
         GXv_char5[0] = AV33SubTipoConCod2 ;
         new web.conceptogetsubtipos(remoteHandle, context).execute( AV9CliCod, AV12ConCodigo, GXv_char6, GXv_char5) ;
         grabanovedadconcepto.this.AV32SubTipoConCod1 = GXv_char6[0] ;
         grabanovedadconcepto.this.AV33SubTipoConCod2 = GXv_char5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&ConCodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " subtipo1 ", "")+GXutil.trim( AV32SubTipoConCod1)+httpContext.getMessage( " subtipo2 ", "")+GXutil.trim( AV33SubTipoConCod2)) ;
         if ( GXutil.strcmp(AV32SubTipoConCod1, new web.subtipovacaciones(remoteHandle, context).executeUdp( )) == 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, "1") ;
            if ( GXutil.strcmp(AV33SubTipoConCod2, new web.subtipovacaciones(remoteHandle, context).executeUdp( )) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               GXv_int2[0] = AV36diasVac ;
               GXv_date8[0] = AV37date ;
               GXv_date7[0] = AV37date ;
               new web.getdiaslicenciaperiodo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, 0, AV35TLiqCod, AV11LegNumero, AV15AgeFecDes, false, true, httpContext.getMessage( "TODOS", ""), true, false, GXv_int2, GXv_date8, GXv_date7) ;
               grabanovedadconcepto.this.AV36diasVac = GXv_int2[0] ;
               grabanovedadconcepto.this.AV37date = GXv_date8[0] ;
               grabanovedadconcepto.this.AV37date = GXv_date7[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&diasVac ", "")+GXutil.trim( GXutil.str( AV36diasVac, 4, 0))) ;
               if ( (0==AV36diasVac) )
               {
                  AV30errores.add(httpContext.getMessage( "Para ingresar novedad concepto de /\"adelanto de vacaciones mes proximo/\" debe tener ingresada una licencia por vacaciones en el mes próximo en novedad enventos. Para adelantar vacaciones del mismo mes debe agregar novedad concepto /\"Adelanto de vacaciones/\"", ""), 0);
                  returnInSub = true;
                  if (true) return;
               }
            }
            else
            {
               GXv_int2[0] = AV36diasVac ;
               GXv_date8[0] = AV37date ;
               GXv_date7[0] = AV37date ;
               new web.getdiaslicenciaperiodo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, 0, AV35TLiqCod, AV11LegNumero, AV15AgeFecDes, false, false, httpContext.getMessage( "TODOS", ""), true, false, GXv_int2, GXv_date8, GXv_date7) ;
               grabanovedadconcepto.this.AV36diasVac = GXv_int2[0] ;
               grabanovedadconcepto.this.AV37date = GXv_date8[0] ;
               grabanovedadconcepto.this.AV37date = GXv_date7[0] ;
               if ( (0==AV36diasVac) )
               {
                  AV30errores.add(httpContext.getMessage( "Para ingresar novedad concepto de /\"Adelanto de vacaciones/\" debe tener ingresada una licencia por vacaciones en el mismo periodo de la liquidación. Para adelantar vacaciones del próximo mes debe agregar novedad concepto /\"Adelanto de Vacaciones mes próximo/\"", ""), 0);
                  returnInSub = true;
                  if (true) return;
               }
            }
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "insert ", "")+AV12ConCodigo+httpContext.getMessage( " &AgeOrden ", "")+GXutil.trim( GXutil.str( AV17AgeOrden, 4, 0))) ;
         /*
            INSERT RECORD ON TABLE AgendaNovedades

         */
         A3CliCod = AV9CliCod ;
         A1EmpCod = AV10EmpCod ;
         A6LegNumero = AV11LegNumero ;
         A25AgeOrden = AV17AgeOrden ;
         A26ConCodigo = AV12ConCodigo ;
         A110AgeCanti = AV13AgeCanti ;
         n110AgeCanti = false ;
         A115AgeVUnit = DecimalUtil.ZERO ;
         n115AgeVUnit = false ;
         A113AgeImporte = AV14AgeImporte ;
         n113AgeImporte = false ;
         A111AgeFecDes = AV15AgeFecDes ;
         n111AgeFecDes = false ;
         A112AgeFecHas = AV16AgeFecHas ;
         n112AgeFecHas = false ;
         A1254AgeLiqNro = 0 ;
         n1254AgeLiqNro = false ;
         n1254AgeLiqNro = true ;
         AV42LiqFrecPag = AV20LegClase ;
         AV41LiqModTra = AV43LegModTra ;
         GXv_char6[0] = "" ;
         GXv_char5[0] = AV40AgePerDescrip ;
         new web.armaliqnombre(remoteHandle, context).execute( AV9CliCod, AV15AgeFecDes, GXv_char6, AV35TLiqCod, AV41LiqModTra, AV42LiqFrecPag, GXv_char5) ;
         grabanovedadconcepto.this.AV40AgePerDescrip = GXv_char5[0] ;
         A2159AgePerDescrip = AV40AgePerDescrip ;
         /* Using cursor P014W2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden), A26ConCodigo, Boolean.valueOf(n110AgeCanti), A110AgeCanti, Boolean.valueOf(n115AgeVUnit), A115AgeVUnit, Boolean.valueOf(n113AgeImporte), A113AgeImporte, Boolean.valueOf(n111AgeFecDes), A111AgeFecDes, Boolean.valueOf(n112AgeFecHas), A112AgeFecHas, Boolean.valueOf(n1254AgeLiqNro), Integer.valueOf(A1254AgeLiqNro), A2159AgePerDescrip});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
         if ( (pr_default.getStatus(0) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
   }

   protected void cleanup( )
   {
      this.aP14[0] = grabanovedadconcepto.this.AV30errores;
      Application.commitDataStores(context, remoteHandle, pr_default, "grabanovedadconcepto");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV30errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46Pgmname = "" ;
      AV15AgeFecDes = GXutil.nullDate() ;
      AV16AgeFecHas = GXutil.nullDate() ;
      AV35TLiqCod = "" ;
      AV21auxDesdeFecha = GXutil.nullDate() ;
      GXt_char4 = "" ;
      GXt_char3 = "" ;
      A115AgeVUnit = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_boolean12 = new boolean[1] ;
      AV32SubTipoConCod1 = "" ;
      AV33SubTipoConCod2 = "" ;
      AV37date = GXutil.nullDate() ;
      GXv_int2 = new short[1] ;
      GXv_date8 = new java.util.Date[1] ;
      GXv_date7 = new java.util.Date[1] ;
      A26ConCodigo = "" ;
      A110AgeCanti = DecimalUtil.ZERO ;
      A113AgeImporte = DecimalUtil.ZERO ;
      A111AgeFecDes = GXutil.nullDate() ;
      A112AgeFecHas = GXutil.nullDate() ;
      AV41LiqModTra = "" ;
      GXv_char6 = new String[1] ;
      AV40AgePerDescrip = "" ;
      GXv_char5 = new String[1] ;
      A2159AgePerDescrip = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabanovedadconcepto__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV46Pgmname = "grabaNovedadConcepto" ;
      /* GeneXus formulas. */
      AV46Pgmname = "grabaNovedadConcepto" ;
      Gx_err = (short)(0) ;
   }

   private byte AV38dia ;
   private byte AV20LegClase ;
   private byte AV8Metodo ;
   private byte AV42LiqFrecPag ;
   private short AV10EmpCod ;
   private short AV31c ;
   private short AV17AgeOrden ;
   private short GXt_int1 ;
   private short AV36diasVac ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private int A1254AgeLiqNro ;
   private int GX_INS3 ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV13AgeCanti ;
   private java.math.BigDecimal AV14AgeImporte ;
   private java.math.BigDecimal A115AgeVUnit ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal A113AgeImporte ;
   private String AV12ConCodigo ;
   private String AV43LegModTra ;
   private String AV46Pgmname ;
   private String AV35TLiqCod ;
   private String GXt_char4 ;
   private String GXt_char3 ;
   private String AV32SubTipoConCod1 ;
   private String AV33SubTipoConCod2 ;
   private String A26ConCodigo ;
   private String AV41LiqModTra ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String Gx_emsg ;
   private java.util.Date AV22DesdeFecha ;
   private java.util.Date AV23HastaFecha ;
   private java.util.Date AV15AgeFecDes ;
   private java.util.Date AV16AgeFecHas ;
   private java.util.Date AV21auxDesdeFecha ;
   private java.util.Date AV37date ;
   private java.util.Date GXv_date8[] ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date A112AgeFecHas ;
   private boolean AV24primeraQuincena ;
   private boolean AV25segundaQuincena ;
   private boolean AV26controlar ;
   private boolean returnInSub ;
   private boolean AV27existe ;
   private boolean GXv_boolean12[] ;
   private boolean Cond_result ;
   private boolean n110AgeCanti ;
   private boolean n115AgeVUnit ;
   private boolean n113AgeImporte ;
   private boolean n111AgeFecDes ;
   private boolean n112AgeFecHas ;
   private boolean n1254AgeLiqNro ;
   private String AV40AgePerDescrip ;
   private String A2159AgePerDescrip ;
   private GXSimpleCollection<String>[] aP14 ;
   private IDataStoreProvider pr_default ;
   private GXSimpleCollection<String> AV30errores ;
}

final  class grabanovedadconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P014W2", "SAVEPOINT gxupdate;INSERT INTO AgendaNovedades(CliCod, EmpCod, LegNumero, AgeOrden, ConCodigo, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgeLiqNro, AgePerDescrip) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(7, (java.math.BigDecimal)parms[8], 2);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(8, (java.math.BigDecimal)parms[10], 2);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.DATE );
               }
               else
               {
                  stmt.setDate(9, (java.util.Date)parms[12]);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.DATE );
               }
               else
               {
                  stmt.setDate(10, (java.util.Date)parms[14]);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(11, ((Number) parms[16]).intValue());
               }
               stmt.setVarchar(12, (String)parms[17], 400, false);
               return;
      }
   }

}

