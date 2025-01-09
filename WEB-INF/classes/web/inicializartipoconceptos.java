package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializartipoconceptos extends GXProcedure
{
   public inicializartipoconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializartipoconceptos.class ), "" );
   }

   public inicializartipoconceptos( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8TipoConCod = "REM_ARG" ;
      /*
         INSERT RECORD ON TABLE TipoDeConcepto

      */
      A37TipoConCod = AV8TipoConCod ;
      A370TipoConDescrip = httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV8TipoConCod), "") ;
      A377TRangoDesde = 110000 ;
      A378TRangoHasta = 499999 ;
      A384TipoConOrden = (short)(1) ;
      A2102TipoConPalabra = httpContext.getMessage( "remunerativos", "") ;
      GXt_int1 = A2120TipoConPai ;
      GXv_int2[0] = GXt_int1 ;
      new web.paisargentina(remoteHandle, context).execute( GXv_int2) ;
      inicializartipoconceptos.this.GXt_int1 = GXv_int2[0] ;
      A2120TipoConPai = GXt_int1 ;
      A2157TipoConTipo = "REM" ;
      /* Using cursor P001O2 */
      pr_default.execute(0, new Object[] {A37TipoConCod, A370TipoConDescrip, Integer.valueOf(A377TRangoDesde), Integer.valueOf(A378TRangoHasta), Short.valueOf(A384TipoConOrden), A2102TipoConPalabra, Short.valueOf(A2120TipoConPai), A2157TipoConTipo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConcepto");
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
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtiponormal(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Básico", "") ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 111000 ;
      A376SubTRangoHasta = 119999 ;
      A2134SubTRestaDias = true ;
      /* Using cursor P001O3 */
      pr_default.execute(1, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(1) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( new web.conceptoafipsueldo(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Sueldo", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "110001", httpContext.getMessage( "Preaviso", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "110002", httpContext.getMessage( "Remuneraciones en especie", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "110003", httpContext.getMessage( "Comida", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "110004", httpContext.getMessage( "Habitación", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "110005", httpContext.getMessage( "Licencias por estudio", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "110006", httpContext.getMessage( "Donación de sangre", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2feriado(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Feriado", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "110008", httpContext.getMessage( "Prest. Dineraria Ley 24577 (primeros 10d)", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "110009", httpContext.getMessage( "Prest. Dineraria Ley 24577 (a cargo de ART)", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtiposac(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Sueldo anual complementario", "") ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 121000 ;
      A376SubTRangoHasta = 129999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O4 */
      pr_default.execute(2, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(2) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( "120000", httpContext.getMessage( "Sueldo anual complementario", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "120001", httpContext.getMessage( "SAC 1er semestre", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "120002", httpContext.getMessage( "SAC 2do semestre", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2sacpropor(remoteHandle, context).executeUdp( ), httpContext.getMessage( "SAC proporcional", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipoextras(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Horas Extras", "") ;
      A1027SubTEsAdicional = true ;
      A375SubTRangoDesde = 131000 ;
      A376SubTRangoHasta = 139999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O5 */
      pr_default.execute(3, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(3) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( new web.conceptoafiphorasextras(remoteHandle, context).executeUdp( ), httpContext.getMessage( " general", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.conceptoafiphorasextras50(remoteHandle, context).executeUdp( ), httpContext.getMessage( " Extras al 50 %", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.conceptoafiphorasextras100(remoteHandle, context).executeUdp( ), httpContext.getMessage( " Extras al 100 %", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.conceptoafiphorasextras200(remoteHandle, context).executeUdp( ), httpContext.getMessage( " Extras al 200 %", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      AV9SubTipoConCod1 = "140000" ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Zona desfavorable", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 141000 ;
      A376SubTRangoHasta = 149999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O6 */
      pr_default.execute(4, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(4) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipovacaciones(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Vacaciones", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A375SubTRangoDesde = 151000 ;
      A376SubTRangoHasta = 159999 ;
      A1027SubTEsAdicional = false ;
      A2134SubTRestaDias = true ;
      /* Using cursor P001O7 */
      pr_default.execute(5, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(5) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( new web.conceptoafipadelantovacaciones(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Adelanto de vacaciones", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipoadicional(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Adicionales", "") ;
      A375SubTRangoDesde = 161000 ;
      A376SubTRangoHasta = 169999 ;
      A1027SubTEsAdicional = true ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O8 */
      pr_default.execute(6, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(6) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2adicionalgeneral(remoteHandle, context).executeUdp( ), httpContext.getMessage( "General", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "160001", httpContext.getMessage( "Adicional por antigüedad", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "160002", httpContext.getMessage( "Adicional por título", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "160003", httpContext.getMessage( "Adicional por tarea", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "160004", httpContext.getMessage( "Adicional por desarraigo", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipopremio(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Premios", "") ;
      A1027SubTEsAdicional = true ;
      A375SubTRangoDesde = 171000 ;
      A376SubTRangoHasta = 179999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O9 */
      pr_default.execute(7, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(7) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( "170000", httpContext.getMessage( "Gratificaciones y/o Premios", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "170001", httpContext.getMessage( "Premio por presentismo", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.conceptoafipbonoproductividad(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Premio por producción", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "170003", httpContext.getMessage( "Comisiones", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "170004", httpContext.getMessage( "Accesorios", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "170005", httpContext.getMessage( "Viáticos sin comprobante", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "170006", httpContext.getMessage( "Propinas habituales no prohibidas", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      AV9SubTipoConCod1 = "499999" ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Redondeo (Remunerativo)", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O10 */
      pr_default.execute(8, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(8) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      AV8TipoConCod = "NRE_ARG" ;
      /*
         INSERT RECORD ON TABLE TipoDeConcepto

      */
      A37TipoConCod = AV8TipoConCod ;
      A370TipoConDescrip = httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV8TipoConCod), "") ;
      A377TRangoDesde = 510000 ;
      A378TRangoHasta = 799999 ;
      A384TipoConOrden = (short)(2) ;
      A2102TipoConPalabra = httpContext.getMessage( "no_remunerativos", "") ;
      GXt_int1 = A2120TipoConPai ;
      GXv_int2[0] = GXt_int1 ;
      new web.paisargentina(remoteHandle, context).execute( GXv_int2) ;
      inicializartipoconceptos.this.GXt_int1 = GXv_int2[0] ;
      A2120TipoConPai = GXt_int1 ;
      A2157TipoConTipo = "NRE" ;
      /* Using cursor P001O11 */
      pr_default.execute(9, new Object[] {A37TipoConCod, A370TipoConDescrip, Integer.valueOf(A377TRangoDesde), Integer.valueOf(A378TRangoHasta), Short.valueOf(A384TipoConOrden), A2102TipoConPalabra, Short.valueOf(A2120TipoConPai), A2157TipoConTipo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConcepto");
      if ( (pr_default.getStatus(9) == 1) )
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
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.getcodafip_asig(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Asignaciones", "") ;
      A1027SubTEsAdicional = true ;
      A375SubTRangoDesde = 511000 ;
      A376SubTRangoHasta = 519999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O12 */
      pr_default.execute(10, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(10) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( "510000", httpContext.getMessage( "Asignaciones Familiares", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "510001", httpContext.getMessage( "Ayuda escolar", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "510002", httpContext.getMessage( "Asignación por hijo/hijo con discapacidad", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "510003", httpContext.getMessage( "Asignación por maternidad", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "510004", httpContext.getMessage( "Asignación por maternidad down", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "510005", httpContext.getMessage( "Asignación por matrimonio", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "510006", httpContext.getMessage( "Asignación por nacimiento / adopción", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "510007", httpContext.getMessage( "Asignación por prenatal", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocapacitacion(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Capacitación", "") ;
      A1027SubTEsAdicional = true ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O13 */
      pr_default.execute(11, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(11) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( "520007", httpContext.getMessage( "Cursos de capacitación", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520008", httpContext.getMessage( "Becas (art. 7 Ley 24.241 y modif.)", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipobeneficio(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Beneficios Sociales", "") ;
      A1027SubTEsAdicional = true ;
      A375SubTRangoDesde = 521000 ;
      A376SubTRangoHasta = 529999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O14 */
      pr_default.execute(12, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(12) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( "520000", httpContext.getMessage( "Beneficios sociales", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520001", httpContext.getMessage( "Servicio de comedor", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520002", httpContext.getMessage( "Gastos médicos", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520003", httpContext.getMessage( "Provisión de ropa de trabajo", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520004", httpContext.getMessage( "Guardería", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520005", httpContext.getMessage( "Provisión de útiles escolares", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520006", httpContext.getMessage( "Gastos de sepelio", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2desempleo(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Desempleo (art. 7 Ley 24.241 y modif.)", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2gratificaciondesempleo(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Gratificación por cese laboral (art. 7 Ley 24.241 y modif.)", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2indemnizaantiguedad(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Indemnización por extinción del contrato de trabajo (art. 7 Ley 24.241 y modif.)", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2indemnizavacaciones(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Vacaciones no gozadas (art. 7 Ley 24.241 y modif.)", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520013", httpContext.getMessage( "Incapacidad permanente (art. 7 Ley 24.241 y modif.)", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520014", httpContext.getMessage( "Indemización por despido", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520015", httpContext.getMessage( "Indemización sustitutiva del preaviso", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520016", httpContext.getMessage( "Integración mes de despido", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( "520017", httpContext.getMessage( "SAC sobre integración o preaviso", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2indemnizavacsac(remoteHandle, context).executeUdp( ), httpContext.getMessage( "SAC sobre vacaciones no gozadas", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtiponre_conaportesos(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Incrementos no remunerativos (con aportes OS)", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 531000 ;
      A376SubTRangoHasta = 539999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O15 */
      pr_default.execute(13, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(13) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtiponre_conaportesycontros(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Incrementos no remunerativos (con aportes y contribuciones OS)", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 541000 ;
      A376SubTRangoHasta = 549999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O16 */
      pr_default.execute(14, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(14) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtiponre_especiales(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Importes no remunerativos especiales", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = true ;
      A375SubTRangoDesde = 551000 ;
      A376SubTRangoHasta = 559999 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O17 */
      pr_default.execute(15, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(15) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2movyvia(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Movilidad y viáticos", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2docmatdid(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Personal docente - material didáctico", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2compenteletrabajo(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Compensación gastos teletrabajo", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2reintegroguarderia(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Compensación gastos de guardería con comprobante", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2beneficioguarderia(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Pago en especies correspondiente a servicio de Guardería", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2devolucionimpganancias(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Impuesto a las ganancias", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtiporedondeo(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Redondeo (No Remunerativo)", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O18 */
      pr_default.execute(16, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(16) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipoanticipodesueldo(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Anticipo de sueldo", "") ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O19 */
      pr_default.execute(17, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(17) == 1) )
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
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipoanticipocuotas(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Anticipo a pagar en cuotas", "") ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O20 */
      pr_default.execute(18, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(18) == 1) )
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
      AV8TipoConCod = "DES_ARG" ;
      /*
         INSERT RECORD ON TABLE TipoDeConcepto

      */
      A37TipoConCod = AV8TipoConCod ;
      A370TipoConDescrip = httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV8TipoConCod), "") ;
      A384TipoConOrden = (short)(3) ;
      A2102TipoConPalabra = httpContext.getMessage( "descuentos", "") ;
      GXt_int1 = A2120TipoConPai ;
      GXv_int2[0] = GXt_int1 ;
      new web.paisargentina(remoteHandle, context).execute( GXv_int2) ;
      inicializartipoconceptos.this.GXt_int1 = GXv_int2[0] ;
      A2120TipoConPai = GXt_int1 ;
      A377TRangoDesde = 821000 ;
      A378TRangoHasta = 829999 ;
      A2157TipoConTipo = "DES" ;
      /* Using cursor P001O21 */
      pr_default.execute(19, new Object[] {A37TipoConCod, A370TipoConDescrip, Integer.valueOf(A377TRangoDesde), Integer.valueOf(A378TRangoHasta), Short.valueOf(A384TipoConOrden), A2102TipoConPalabra, Short.valueOf(A2120TipoConPai), A2157TipoConTipo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConcepto");
      if ( (pr_default.getStatus(19) == 1) )
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
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipojubilacion(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Sistema previsional", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A740SubTDescuLey = true ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O22 */
      pr_default.execute(20, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A740SubTDescuLey), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(20) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipopami(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "INSSJyP", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A740SubTDescuLey = true ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O23 */
      pr_default.execute(21, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A740SubTDescuLey), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(21) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipoobrasocial(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Obra Social", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A740SubTDescuLey = true ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O24 */
      pr_default.execute(22, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A740SubTDescuLey), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(22) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      AV9SubTipoConCod1 = "810003" ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Fondo Solidario de Redistribución (ex ANSSAL)", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O25 */
      pr_default.execute(23, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(23) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocuotasindical(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Cuota Sindical", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A740SubTDescuLey = true ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O26 */
      pr_default.execute(24, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A740SubTDescuLey), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(24) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      AV9SubTipoConCod1 = "810005" ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Seguro de Vida", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O27 */
      pr_default.execute(25, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(25) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      AV9SubTipoConCod1 = "810006" ;
      AV10SubTipoConDes1 = httpContext.getMessage( "RENATEA (ex RENATRE)", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O28 */
      pr_default.execute(26, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(26) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      AV9SubTipoConCod1 = "810007" ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Préstamos", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O29 */
      pr_default.execute(27, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(27) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipoganancias(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Ganancias", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O30 */
      pr_default.execute(28, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(28) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, httpContext.getMessage( "IMPUESTO A LAS GANANCIAS", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipoobrasocialadherentes(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Obra Social - Adherentes", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A740SubTDescuLey = true ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O31 */
      pr_default.execute(29, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A740SubTDescuLey), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(29) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      AV9SubTipoConCod1 = "810010" ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Fondo Solidario de Redistribución (ex ANSSAL) - Adherentes", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O32 */
      pr_default.execute(30, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(30) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipodescuentootros(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      AV10SubTipoConDes1 = httpContext.getMessage( "Otros descuentos", "") ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = AV10SubTipoConDes1 ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O33 */
      pr_default.execute(31, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(31) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( AV9SubTipoConCod1, AV10SubTipoConDes1, AV8TipoConCod, AV9SubTipoConCod1) ;
      AV8TipoConCod = "CAL_ARG" ;
      /*
         INSERT RECORD ON TABLE TipoDeConcepto

      */
      A37TipoConCod = AV8TipoConCod ;
      A370TipoConDescrip = httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV8TipoConCod), "") ;
      A377TRangoDesde = 0 ;
      A378TRangoHasta = 0 ;
      A384TipoConOrden = (short)(4) ;
      A2102TipoConPalabra = httpContext.getMessage( "calculos", "") ;
      GXt_int1 = A2120TipoConPai ;
      GXv_int2[0] = GXt_int1 ;
      new web.paisargentina(remoteHandle, context).execute( GXv_int2) ;
      inicializartipoconceptos.this.GXt_int1 = GXv_int2[0] ;
      A2120TipoConPai = GXt_int1 ;
      A2157TipoConTipo = "CAL" ;
      /* Using cursor P001O34 */
      pr_default.execute(32, new Object[] {A37TipoConCod, A370TipoConDescrip, Integer.valueOf(A377TRangoDesde), Integer.valueOf(A378TRangoHasta), Short.valueOf(A384TipoConOrden), A2102TipoConPalabra, Short.valueOf(A2120TipoConPai), A2157TipoConTipo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConcepto");
      if ( (pr_default.getStatus(32) == 1) )
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
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocontribucion(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Contribución Patronal", "") ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O35 */
      pr_default.execute(33, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(33) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2dependenciacontr(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Dependencia", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculootros(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Otros", "") ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O36 */
      pr_default.execute(34, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(34) == 1) )
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
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Base Imponible", "") ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O37 */
      pr_default.execute(35, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(35) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2baseimponibleaportes(remoteHandle, context).executeUdp( ), httpContext.getMessage( "De aportes", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2baseimponiblecontribucion(remoteHandle, context).executeUdp( ), httpContext.getMessage( "De contribuciones", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculoganancias(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "Ganancias", "") ;
      A1027SubTEsAdicional = false ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O38 */
      pr_default.execute(36, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A1027SubTEsAdicional), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(36) == 1) )
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
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2gananciastopes(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Topes", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2gananciasotros(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Otros", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2gananciassac(remoteHandle, context).executeUdp( ), httpContext.getMessage( "SAC", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2deduccionesgenerales(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Deducciones generales mensuales", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2deduccionesgeneralesanuales(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Deducciones generales anuales", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2deduccionespersonales(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Deducciones personales", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2pagosacuenta(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Pagos a cuenta", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      new web.addsubtipo(remoteHandle, context).execute( new web.subtipo2otrosempleos(remoteHandle, context).executeUdp( ), httpContext.getMessage( "Otros empleos", ""), AV8TipoConCod, AV9SubTipoConCod1) ;
      GXt_char3 = AV9SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculosac(remoteHandle, context).execute( GXv_char4) ;
      inicializartipoconceptos.this.GXt_char3 = GXv_char4[0] ;
      AV9SubTipoConCod1 = GXt_char3 ;
      /*
         INSERT RECORD ON TABLE TipoDeConceptoSubtipo1

      */
      A37TipoConCod = AV8TipoConCod ;
      A38SubTipoConCod1 = AV9SubTipoConCod1 ;
      A371SubTipoConDes1 = httpContext.getMessage( "SAC", "") ;
      A375SubTRangoDesde = 0 ;
      A376SubTRangoHasta = 0 ;
      A2134SubTRestaDias = false ;
      /* Using cursor P001O39 */
      pr_default.execute(37, new Object[] {A37TipoConCod, A38SubTipoConCod1, A371SubTipoConDes1, Integer.valueOf(A375SubTRangoDesde), Integer.valueOf(A376SubTRangoHasta), Boolean.valueOf(A2134SubTRestaDias)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoDeConceptoSubtipo1");
      if ( (pr_default.getStatus(37) == 1) )
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
      new web.altaafipconcepto(remoteHandle, context).execute( "560000", httpContext.getMessage( "Mensual - PPC y CCT Especiales", ""), "NRE_ARG", new web.subtiponre_especiales(remoteHandle, context).executeUdp( )) ;
      new web.altaafipconcepto(remoteHandle, context).execute( "560001", httpContext.getMessage( "SAC - PPC y CCT Especiales", ""), "NRE_ARG", new web.subtiponre_especiales(remoteHandle, context).executeUdp( )) ;
      new web.altaafipconcepto(remoteHandle, context).execute( "560002", httpContext.getMessage( "SAC Proporcional - PPC y CCT Especiales", ""), "NRE_ARG", new web.subtiponre_especiales(remoteHandle, context).executeUdp( )) ;
      new web.altaafipconcepto(remoteHandle, context).execute( "560003", httpContext.getMessage( "Vacaciones - PPC y CCT Especiales", ""), "NRE_ARG", new web.subtiponre_especiales(remoteHandle, context).executeUdp( )) ;
      new web.altaafipconcepto(remoteHandle, context).execute( "560004", httpContext.getMessage( "Asign. dineraria progr. sociales, educativos o empleo – Dec. 551/2022", ""), "NRE_ARG", new web.subtiponre_especiales(remoteHandle, context).executeUdp( )) ;
      new web.altaafipconcepto(remoteHandle, context).execute( "560005", httpContext.getMessage( "Asign. No remunerativa Dec 841/2022", ""), "NRE_ARG", new web.subtiponre_especiales(remoteHandle, context).executeUdp( )) ;
      new web.altaafipconcepto(remoteHandle, context).execute( "560006", httpContext.getMessage( "Asignación no Remunerativa Dcto 438/2023", ""), "NRE_ARG", new web.subtiponre_especiales(remoteHandle, context).executeUdp( )) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializartipoconceptos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8TipoConCod = "" ;
      A37TipoConCod = "" ;
      A370TipoConDescrip = "" ;
      A2102TipoConPalabra = "" ;
      A2157TipoConTipo = "" ;
      Gx_emsg = "" ;
      AV9SubTipoConCod1 = "" ;
      A38SubTipoConCod1 = "" ;
      A371SubTipoConDes1 = "" ;
      AV10SubTipoConDes1 = "" ;
      GXv_int2 = new short[1] ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializartipoconceptos__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A384TipoConOrden ;
   private short A2120TipoConPai ;
   private short Gx_err ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private int GX_INS59 ;
   private int A377TRangoDesde ;
   private int A378TRangoHasta ;
   private int GX_INS60 ;
   private int A375SubTRangoDesde ;
   private int A376SubTRangoHasta ;
   private String AV8TipoConCod ;
   private String A37TipoConCod ;
   private String A2102TipoConPalabra ;
   private String A2157TipoConTipo ;
   private String Gx_emsg ;
   private String AV9SubTipoConCod1 ;
   private String A38SubTipoConCod1 ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private boolean A1027SubTEsAdicional ;
   private boolean A2134SubTRestaDias ;
   private boolean A740SubTDescuLey ;
   private String A370TipoConDescrip ;
   private String A371SubTipoConDes1 ;
   private String AV10SubTipoConDes1 ;
   private IDataStoreProvider pr_default ;
}

final  class inicializartipoconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P001O2", "SAVEPOINT gxupdate;INSERT INTO TipoDeConcepto(TipoConCod, TipoConDescrip, TRangoDesde, TRangoHasta, TipoConOrden, TipoConPalabra, TipoConPai, TipoConTipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O3", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O4", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O5", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O6", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O7", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O8", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O9", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O10", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O11", "SAVEPOINT gxupdate;INSERT INTO TipoDeConcepto(TipoConCod, TipoConDescrip, TRangoDesde, TRangoHasta, TipoConOrden, TipoConPalabra, TipoConPai, TipoConTipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O12", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O13", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O14", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O15", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O16", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O17", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O18", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O19", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O20", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O21", "SAVEPOINT gxupdate;INSERT INTO TipoDeConcepto(TipoConCod, TipoConDescrip, TRangoDesde, TRangoHasta, TipoConOrden, TipoConPalabra, TipoConPai, TipoConTipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O22", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O23", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O24", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O25", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O26", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O27", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O28", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O29", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O30", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O31", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTDescuLey, SubTEsAdicional, SubTRestaDias) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O32", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O33", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O34", "SAVEPOINT gxupdate;INSERT INTO TipoDeConcepto(TipoConCod, TipoConDescrip, TRangoDesde, TRangoHasta, TipoConOrden, TipoConPalabra, TipoConPai, TipoConTipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O35", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O36", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTRestaDias, SubTDescuLey, SubTEsAdicional) VALUES(?, ?, ?, ?, ?, ?, FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O37", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTRestaDias, SubTDescuLey, SubTEsAdicional) VALUES(?, ?, ?, ?, ?, ?, FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O38", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTEsAdicional, SubTRestaDias, SubTDescuLey) VALUES(?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001O39", "SAVEPOINT gxupdate;INSERT INTO TipoDeConceptoSubtipo1(TipoConCod, SubTipoConCod1, SubTipoConDes1, SubTRangoDesde, SubTRangoHasta, SubTRestaDias, SubTDescuLey, SubTEsAdicional) VALUES(?, ?, ?, ?, ?, ?, FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 4 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 17 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 19 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 20 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               return;
            case 21 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               return;
            case 22 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               return;
            case 23 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 24 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               return;
            case 25 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 26 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 27 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 28 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 29 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 31 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 32 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               return;
            case 33 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 34 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
            case 35 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
            case 36 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
            case 37 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
      }
   }

}

