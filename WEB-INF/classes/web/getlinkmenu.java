package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlinkmenu extends GXProcedure
{
   public getlinkmenu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlinkmenu.class ), "" );
   }

   public getlinkmenu( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             byte aP2 ,
                             String aP3 ,
                             String aP4 )
   {
      getlinkmenu.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        byte aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             byte aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String[] aP5 )
   {
      getlinkmenu.this.AV12CliCod = aP0;
      getlinkmenu.this.AV13EmpCod = aP1;
      getlinkmenu.this.AV23parm_PerfilId = aP2;
      getlinkmenu.this.AV22parm_MenuItemId = aP3;
      getlinkmenu.this.AV18MenuOpcCod = aP4;
      getlinkmenu.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( false )
      {
         callWebObject(formatLink("web.webpanel5", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV22parm_MenuItemId)==0) )
      {
         AV8PerfilId = AV23parm_PerfilId ;
         AV11MenuItemId = AV22parm_MenuItemId ;
      }
      else
      {
         GXt_int1 = AV19SecUserId ;
         GXv_int2[0] = GXt_int1 ;
         new web.getusuloggedid(remoteHandle, context).execute( GXv_int2) ;
         getlinkmenu.this.GXt_int1 = GXv_int2[0] ;
         AV19SecUserId = GXt_int1 ;
         GXv_int3[0] = AV20RolId ;
         GXv_int4[0] = AV8PerfilId ;
         GXv_int5[0] = AV21MenuVerId ;
         new web.getusumenu(remoteHandle, context).execute( AV19SecUserId, GXv_int3, GXv_int4, GXv_int5) ;
         getlinkmenu.this.AV20RolId = GXv_int3[0] ;
         getlinkmenu.this.AV8PerfilId = GXv_int4[0] ;
         getlinkmenu.this.AV21MenuVerId = GXv_int5[0] ;
         GXv_char6[0] = AV11MenuItemId ;
         new web.getmenuitemporopc(remoteHandle, context).execute( AV20RolId, AV8PerfilId, AV21MenuVerId, AV18MenuOpcCod, GXv_char6) ;
         getlinkmenu.this.AV11MenuItemId = GXv_char6[0] ;
      }
      /* Using cursor P01UP2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV8PerfilId), AV11MenuItemId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1937MenuItemId = P01UP2_A1937MenuItemId[0] ;
         A1925PerfilId = P01UP2_A1925PerfilId[0] ;
         A1938MItemEsMenu = P01UP2_A1938MItemEsMenu[0] ;
         AV9MItemEsMenu = A1938MItemEsMenu ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV28datos = httpContext.getMessage( "&PerfilId ", "") + GXutil.trim( GXutil.str( AV8PerfilId, 2, 0)) + httpContext.getMessage( " &MenuItemId ", "") + GXutil.trim( AV11MenuItemId) + httpContext.getMessage( " &MItemEsMenu  ", "") + GXutil.trim( GXutil.booltostr( AV9MItemEsMenu)) + httpContext.getMessage( " &MenuItemId ", "") + GXutil.trim( AV11MenuItemId) ;
      GXv_int2[0] = AV15PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV12CliCod, GXv_int2) ;
      getlinkmenu.this.AV15PaiCod = GXv_int2[0] ;
      if ( AV8PerfilId == 3 )
      {
         GXv_char6[0] = AV17ConveCodigo ;
         new web.getconvecodsesion(remoteHandle, context).execute( GXv_char6) ;
         getlinkmenu.this.AV17ConveCodigo = GXv_char6[0] ;
      }
      if ( AV9MItemEsMenu )
      {
         AV10URL = formatLink("web.menu", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
      }
      else
      {
         if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "EsquemaHorasEspeciales", "")) == 0 )
         {
            GXv_char6[0] = AV29CliConvenio ;
            new web.getesquemadefault(remoteHandle, context).execute( AV12CliCod, GXv_char6) ;
            getlinkmenu.this.AV29CliConvenio = GXv_char6[0] ;
            AV10URL = formatLink("web.esquemahorasespecialesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(AV29CliConvenio))}, new String[] {"MenuOpcCod","CliConvenio"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "EsquemaHorasExtras", "")) == 0 )
         {
            GXv_char6[0] = AV29CliConvenio ;
            new web.getesquemadefault(remoteHandle, context).execute( AV12CliCod, GXv_char6) ;
            getlinkmenu.this.AV29CliConvenio = GXv_char6[0] ;
            AV10URL = formatLink("web.esquemahorasextrasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(AV29CliConvenio))}, new String[] {"MenuOpcCod","CliConvenio"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "EsquemaCategorías", "")) == 0 )
         {
            GXv_char6[0] = AV29CliConvenio ;
            new web.getesquemadefault(remoteHandle, context).execute( AV12CliCod, GXv_char6) ;
            getlinkmenu.this.AV29CliConvenio = GXv_char6[0] ;
            AV10URL = formatLink("web.esquemacategoriaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(AV29CliConvenio))}, new String[] {"MenuOpcCod","CliConvenio"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Ajuste de sueldos por inflación", "")) == 0 )
         {
            AV10URL = formatLink("web.ajustesporinflacion", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Egresos / Permanencias", "")) == 0 )
         {
            AV10URL = formatLink("web.legajo_permanenciaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Cuenta corriente de vacaciones", "")) == 0 )
         {
            AV10URL = formatLink("web.legajo_cuenta_licenciasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Conexiones REST", "")) == 0 )
         {
            AV10URL = formatLink("web.rest_locationww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Conexiones SOAP", "")) == 0 )
         {
            AV10URL = formatLink("web.soap_locationww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Reinicializar datos", "")) == 0 )
         {
            AV10URL = formatLink("web.reinicializardatos", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Conceptos", "")) == 0 ) || ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Fórmula", "")) == 0 ) )
         {
            AV10URL = formatLink("web.conceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Periodos", "")) == 0 )
         {
            AV10URL = formatLink("web.periodos", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "PeriodoView", "")) == 0 )
         {
            AV25PeriodoLiq = localUtil.ctod( AV26websession.getValue(httpContext.getMessage( "&PeriodoLiq", "")), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV25PeriodoLiq)) )
            {
               AV10URL = formatLink("web.periodoview", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "PeriodoView", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV25PeriodoLiq)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LiquidacionWW", "")))}, new String[] {"MenuOpcCod","CliCod","EmpCod","PeriodoLiq","TabCode"})  ;
            }
            else
            {
               AV10URL = formatLink("web.periodos", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
            }
         }
         else if ( ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Liquidaciones", "")) == 0 ) || ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "LiquidacionLegajo", "")) == 0 ) )
         {
            GXv_char6[0] = AV24MItemPadreDef ;
            new web.defaultmenuopcpadre(remoteHandle, context).execute( AV8PerfilId, AV11MenuItemId, GXv_char6) ;
            getlinkmenu.this.AV24MItemPadreDef = GXv_char6[0] ;
            AV27LiqNro = (int)(GXutil.lval( AV26websession.getValue(httpContext.getMessage( "&LiqNro", "")))) ;
            AV10URL = formatLink("web.liquidacionview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24MItemPadreDef)),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV27LiqNro,8,0)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LiquidacionLegajo", "")))}, new String[] {"auxMenuOpcCod","CliCod","EmpCod","LiqNro","TabCode"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Exportar liquidaciones", "")) == 0 )
         {
            AV10URL = formatLink("web.liquidacion_export3", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Legajos", "")) == 0 )
         {
            AV10URL = formatLink("web.legajosww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0)),GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SelectedCliCod","SelectedEmpCod","SelectedLegNumero","MenuOpcCod","modoPalabra"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Horas trabajadas y conceptos adicionales", "")) == 0 )
         {
            AV10URL = formatLink("web.novedadesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Faltas y llegadas tarde", "")) == 0 )
         {
            AV10URL = formatLink("web.faltas_y_tardesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Vacaciones y licencias", "")) == 0 )
         {
            AV10URL = formatLink("web.novedadeventosww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Deducciones y reintegros", "")) == 0 )
         {
            AV10URL = formatLink("web.legajo_deduccionesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Reportes", "")) == 0 ) || ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Reporte", "")) == 0 ) )
         {
            AV10URL = formatLink("web.liquidacion_export3", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Libro de Sueldos Digital", "")) == 0 )
         {
            AV10URL = formatLink("web.librosueldosdigital", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Formulario 1357", "")) == 0 )
         {
            AV10URL = formatLink("web.f1357cabww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Importar legajos", "")) == 0 )
         {
            AV10URL = formatLink("web.importacion_legajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Importar liquidaciones históricas", "")) == 0 )
         {
            AV10URL = formatLink("web.importarliquidacioneswizard2", new String[] {GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.booltostr(false)),GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"PreviousStep","CurrentStep","GoingBack","MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Obligaciones", "")) == 0 )
         {
            AV10URL = formatLink("web.obligacionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenios", "")) == 0 )
         {
            AV10URL = formatLink("web.clienteconveniosww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Pruebas", "")) == 0 )
         {
            AV10URL = formatLink("web.pruebas", new String[] {}, new String[] {})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Actualizaciones", "")) == 0 )
         {
            AV10URL = formatLink("web.cliente_updateww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Usuarios", "")) == 0 )
         {
            AV10URL = formatLink("web.wwpbaseobjects.secuserww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Bancos", "")) == 0 )
         {
            AV10URL = formatLink("web.bancoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "EmpBancos", "")) == 0 )
         {
            AV10URL = formatLink("web.empresabancosww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "EmpBandaSalarial", "")) == 0 )
         {
            AV10URL = formatLink("web.banda_salarialww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "EmpSucursales", "")) == 0 )
         {
            AV10URL = formatLink("web.sucursalww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Obras Sociales", "")) == 0 )
         {
            AV10URL = formatLink("web.obrasocialww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Sindicatos", "")) == 0 )
         {
            AV10URL = formatLink("web.sindicatoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Áreas", "")) == 0 )
         {
            AV10URL = formatLink("web.seccionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Puestos", "")) == 0 )
         {
            AV10URL = formatLink("web.puestoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Motivos de Egreso", "")) == 0 )
         {
            AV10URL = formatLink("web.motivoegresoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Parámetros", "")) == 0 )
         {
            AV10URL = formatLink("web.parametros", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Parámetros todos", "")) == 0 )
         {
            AV10URL = formatLink("web.paramww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Parámetros backend", "")) == 0 )
         {
            AV10URL = formatLink("web.parametrosbackend", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Variables", "")) == 0 )
         {
            AV10URL = formatLink("web.variable_listarww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Cálculos", "")) == 0 )
         {
            AV10URL = formatLink("web.calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Tratamientos de exención IIGG", "")) == 0 )
         {
            AV10URL = formatLink("web.tipo_aplicacion_gananciasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Condiciones de exención", "")) == 0 )
         {
            AV10URL = formatLink("web.condicion_exencion_iiggww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Datos principales", "")) == 0 )
         {
            AV10URL = formatLink("web.empresa_cabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "UPD", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"TrnMode","CliCod","EmpCod","MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Licencias en clase jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.empresabase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("licencia"))}, new String[] {"MenuOpcCod","EmpBaseClaseLeg","EmpBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Licencias en clase mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.empresabase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("licencia"))}, new String[] {"MenuOpcCod","EmpBaseClaseLeg","EmpBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Feriados en clase jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.empresabase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("feriado"))}, new String[] {"MenuOpcCod","EmpBaseClaseLeg","EmpBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Feriados en clase mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.empresabase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("feriado"))}, new String[] {"MenuOpcCod","EmpBaseClaseLeg","EmpBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Hora normal en clase jornal", "")) == 0 )
         {
            GXv_boolean7[0] = AV14existe ;
            new web.existebasedecalcempresa(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, (byte)(2), "horaNormal", GXv_boolean7) ;
            getlinkmenu.this.AV14existe = GXv_boolean7[0] ;
            if ( AV14existe )
            {
               AV10URL = formatLink("web.empbasehoranormal", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"TrnMode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2","MenuOpcCod"})  ;
            }
            else
            {
               AV10URL = formatLink("web.empbasehoranormal", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"TrnMode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2","MenuOpcCod"})  ;
            }
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Hora normal en clase mensual", "")) == 0 )
         {
            GXv_boolean7[0] = AV14existe ;
            new web.existebasedecalcempresa(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, (byte)(2), "horaNormal", GXv_boolean7) ;
            getlinkmenu.this.AV14existe = GXv_boolean7[0] ;
            if ( AV14existe )
            {
               AV10URL = formatLink("web.empresabase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2"})  ;
            }
            else
            {
               AV10URL = formatLink("web.empresabase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2"})  ;
            }
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Horas extras", "")) == 0 )
         {
            AV10URL = formatLink("web.empresa_tiposdetrabajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Horas extras extraordinarias", "")) == 0 )
         {
            AV10URL = formatLink("web.empresa_horasextras_pordiaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "ReligionesEmpresa", "")) == 0 )
         {
            AV10URL = formatLink("web.empresareligionesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "OrigenesEmpresa", "")) == 0 )
         {
            AV10URL = formatLink("web.empresaorigenesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Clasificaciones", "")) == 0 )
         {
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Clientes", "")) == 0 )
         {
            AV10URL = formatLink("web.clienteww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Religiones", "")) == 0 )
         {
            AV10URL = formatLink("web.religionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Origenes", "")) == 0 )
         {
            AV10URL = formatLink("web.origenww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Tipos de concepto", "")) == 0 )
         {
            AV10URL = formatLink("web.tipodeconceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Tipos de trabajo", "")) == 0 )
         {
            AV10URL = formatLink("web.tipotrabajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Países", "")) == 0 )
         {
            AV10URL = formatLink("web.paisww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Roles", "")) == 0 )
         {
            AV10URL = formatLink("web.rolusuarioww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Perfiles", "")) == 0 )
         {
            AV10URL = formatLink("web.perfilww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "SVGs", "")) == 0 )
         {
            AV10URL = formatLink("web.svgww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Items de menú", "")) == 0 )
         {
            AV10URL = formatLink("web.menuitemww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Menúes", "")) == 0 )
         {
            AV10URL = formatLink("web.menuversionesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Actividades", "")) == 0 )
         {
            AV10URL = formatLink("web.actividadafipww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Tipos de empleador", "")) == 0 )
         {
            AV10URL = formatLink("web.tipoempleadorww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Zonas", "")) == 0 )
         {
            AV10URL = formatLink("web.zonaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Situaciones de revista", "")) == 0 )
         {
            AV10URL = formatLink("web.situacionrevistaafipww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Siniestrados", "")) == 0 )
         {
            AV10URL = formatLink("web.siniestradoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Condiciones", "")) == 0 )
         {
            AV10URL = formatLink("web.condicionafipww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Modalidades de contratación", "")) == 0 )
         {
            AV10URL = formatLink("web.modalidadafipww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "AFIPConcepto", "")) == 0 )
         {
            AV10URL = formatLink("web.afipconceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Conceptos", "")) == 0 )
         {
            AV10URL = formatLink("web.conceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Condiciones concepto", "")) == 0 )
         {
            AV10URL = formatLink("web.condiciones_conceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Bancos", "")) == 0 )
         {
            AV10URL = formatLink("web.bancoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Obras sociales", "")) == 0 )
         {
            AV10URL = formatLink("web.obrasocialww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Areas", "")) == 0 )
         {
            AV10URL = formatLink("web.seccionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Puestos", "")) == 0 )
         {
            AV10URL = formatLink("web.puestoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Motivos de egreso", "")) == 0 )
         {
            AV10URL = formatLink("web.motivoegresoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Estados", "")) == 0 ) || ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Estados / Licencias", "")) == 0 ) )
         {
            AV10URL = formatLink("web.estadoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Template recibos", "")) == 0 )
         {
            AV10URL = formatLink("web.templatereciboww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Tratamientos de exención IIGG", "")) == 0 )
         {
            AV10URL = formatLink("web.tipo_aplicacion_gananciasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Condiciones de exención", "")) == 0 )
         {
            AV10URL = formatLink("web.condicion_exencion_iiggww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Códigos SIRADIG", "")) == 0 )
         {
            AV10URL = formatLink("web.siradig_codigosww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Embargabilidad", "")) == 0 )
         {
            AV10URL = formatLink("web.embargabilidadww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Tipos de obligación", "")) == 0 )
         {
            AV10URL = formatLink("web.tipo_obligacionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Tipos de liquidación", "")) == 0 )
         {
            AV10URL = formatLink("web.tipoliquidacionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Clientes", "")) == 0 )
         {
            AV10URL = formatLink("web.clienteww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Parentescos", "")) == 0 )
         {
            AV10URL = formatLink("web.parentescoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Conceptos exportar", "")) == 0 )
         {
            AV10URL = formatLink("web.conceptos_exportww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Liberación de actualizaciones", "")) == 0 )
         {
            AV10URL = formatLink("web.cliente_releaseww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Conceptos", "")) == 0 )
         {
            AV10URL = formatLink("web.conceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Sexos", "")) == 0 )
         {
            AV10URL = formatLink("web.sexosww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Estados civiles", "")) == 0 )
         {
            AV10URL = formatLink("web.estados_civilesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Tipos de feriado", "")) == 0 )
         {
            AV10URL = formatLink("web.tipo_feriadoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Feriados", "")) == 0 )
         {
            AV10URL = formatLink("web.feriadoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Agenda de feriados", "")) == 0 )
         {
            AV10URL = formatLink("web.feriado_agendaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Datos de país", "")) == 0 )
         {
            AV10URL = formatLink("web.paiscabecera", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0))}, new String[] {"Mode","PaiCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "País licencias jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.paisbase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("licencia"))}, new String[] {"MenuOpcCod","PaiBaseClaseLeg","PaiBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenio licencias jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("licencia"))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "País licencias mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.paisbase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("licencia"))}, new String[] {"MenuOpcCod","PaiBaseClaseLeg","PaiBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenio licencias mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("licencia"))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "País feriados jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.paisbase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("feriado"))}, new String[] {"MenuOpcCod","PaiBaseClaseLeg","PaiBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenio feriados jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("feriado"))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "País feriados mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.paisbase_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("feriado"))}, new String[] {"MenuOpcCod","PaiBaseClaseLeg","PaiBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenio feriados mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("feriado"))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "País hora normal jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.paisbase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","PaiCod","PaiBaseClaseLeg","PaiBaseTipo","PaiBaseCod1","PaiBaseCod2"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenio hora normal jornal", "")) == 0 )
         {
            GXv_boolean7[0] = AV14existe ;
            new web.existebasedecalculo(remoteHandle, context).execute( AV12CliCod, AV15PaiCod, AV17ConveCodigo, (byte)(2), "horaNormal", GXv_boolean7) ;
            getlinkmenu.this.AV14existe = GXv_boolean7[0] ;
            if ( AV14existe )
            {
               AV10URL = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConveCodigo)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
            }
            else
            {
               AV10URL = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConveCodigo)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
            }
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "País hora normal mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.paisbase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","PaiCod","PaiBaseClaseLeg","PaiBaseTipo","PaiBaseCod1","PaiBaseCod2"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenio hora normal mensual", "")) == 0 )
         {
            GXv_boolean7[0] = AV14existe ;
            new web.existebasedecalculo(remoteHandle, context).execute( AV12CliCod, AV15PaiCod, AV17ConveCodigo, (byte)(1), "horaNormal", GXv_boolean7) ;
            getlinkmenu.this.AV14existe = GXv_boolean7[0] ;
            if ( AV14existe )
            {
               AV10URL = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConveCodigo)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
            }
            else
            {
               AV10URL = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConveCodigo)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
            }
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "País Horas extras", "")) == 0 )
         {
            AV10URL = formatLink("web.paistipotrabajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenio Horas extras", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_tiposdetrabajoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "País Horas extras extraordinarias", "")) == 0 )
         {
            AV10URL = formatLink("web.paisextraordinariasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenio Horas extras extraordinarias", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_horasextras_pordiaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Adicionales reservados", "")) == 0 )
         {
            AV10URL = formatLink("web.adicionalww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Provincias", "")) == 0 )
         {
            AV10URL = formatLink("web.provinciaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Localidades", "")) == 0 )
         {
            AV10URL = formatLink("web.localidadww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "A.R.T.", "")) == 0 )
         {
            AV10URL = formatLink("web.artww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Sindicatos", "")) == 0 )
         {
            AV10URL = formatLink("web.sindicatoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "PaisConvenios", "")) == 0 )
         {
            AV10URL = formatLink("web.convenioww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Vacaciones", "")) == 0 )
         {
            AV10URL = formatLink("web.paisvacacionesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Cálculos", "")) == 0 )
         {
            AV10URL = formatLink("web.calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Liberación de actualizaciones", "")) == 0 )
         {
            AV10URL = formatLink("web.cliente_releaseww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Convenios disponibles", "")) == 0 )
         {
            AV10URL = formatLink("web.clienteconveniosww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Datos de convenio", "")) == 0 )
         {
            AV10URL = formatLink("web.clienteconvenio_particularidadesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Importes de convenio", "")) == 0 )
         {
            AV10URL = formatLink("web.clienteconvenio_importesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Adicionales", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_adicionalww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Opciones de adicional", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_adicional_opcionesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Importes de adicional", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_adicional_importesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Categorías", "")) == 0 )
         {
            AV10URL = formatLink("web.categoriaalta2ww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Escalas salariales", "")) == 0 )
         {
            AV10URL = formatLink("web.escalasalarialww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Actualizar tarifas categorías", "")) == 0 )
         {
            AV10URL = formatLink("web.actualizartarifas", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Vacaciones por antigüedad", "")) == 0 )
         {
            AV10URL = formatLink("web.clientecct_vacacionesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Fondo de cese laboral", "")) == 0 )
         {
            AV10URL = formatLink("web.clientecct_fondoceseww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Licencias que cancelan adicionales", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_adicionalcancelaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Configuración para cálculos de licencias en clase jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("licencia"))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Configuración para cálculos de licencias en clase mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("licencia"))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Configuración para cálculos de feriados en clase jornal", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("feriado"))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Configuración para cálculos de feriados en clase mensual", "")) == 0 )
         {
            AV10URL = formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("feriado"))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Configuración para cálculos de hora normal en clase jornal", "")) == 0 )
         {
            GXv_boolean7[0] = AV14existe ;
            new web.existebasedecalculo(remoteHandle, context).execute( AV12CliCod, AV15PaiCod, AV17ConveCodigo, (byte)(2), "horaNormal", GXv_boolean7) ;
            getlinkmenu.this.AV14existe = GXv_boolean7[0] ;
            if ( AV14existe )
            {
               AV10URL = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConveCodigo)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
            }
            else
            {
               AV10URL = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConveCodigo)),GXutil.URLEncode(GXutil.ltrimstr(2,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
            }
         }
         else if ( GXutil.strcmp(AV11MenuItemId, httpContext.getMessage( "Configuración para cálculos de hora normal en clase mensual", "")) == 0 )
         {
            GXv_boolean7[0] = AV14existe ;
            new web.existebasedecalculo(remoteHandle, context).execute( AV12CliCod, AV15PaiCod, AV17ConveCodigo, (byte)(1), "horaNormal", GXv_boolean7) ;
            getlinkmenu.this.AV14existe = GXv_boolean7[0] ;
            if ( AV14existe )
            {
               AV10URL = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConveCodigo)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
            }
            else
            {
               AV10URL = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV12CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV15PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV17ConveCodigo)),GXutil.URLEncode(GXutil.ltrimstr(1,9,0)),GXutil.URLEncode(GXutil.rtrim("horaNormal")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
            }
         }
         else
         {
            AV10URL = formatLink("web.home_temp", new String[] {}, new String[] {})  ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "datos ", "")+AV28datos) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getlinkmenu.this.AV10URL;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10URL = "" ;
      AV11MenuItemId = "" ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new long[1] ;
      scmdbuf = "" ;
      P01UP2_A1937MenuItemId = new String[] {""} ;
      P01UP2_A1925PerfilId = new byte[1] ;
      P01UP2_A1938MItemEsMenu = new boolean[] {false} ;
      A1937MenuItemId = "" ;
      AV28datos = "" ;
      GXv_int2 = new short[1] ;
      AV17ConveCodigo = "" ;
      AV29CliConvenio = "" ;
      AV25PeriodoLiq = GXutil.nullDate() ;
      AV26websession = httpContext.getWebSession();
      AV24MItemPadreDef = "" ;
      GXv_char6 = new String[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV33Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlinkmenu__default(),
         new Object[] {
             new Object[] {
            P01UP2_A1937MenuItemId, P01UP2_A1925PerfilId, P01UP2_A1938MItemEsMenu
            }
         }
      );
      AV33Pgmname = "getLinkMenu" ;
      /* GeneXus formulas. */
      AV33Pgmname = "getLinkMenu" ;
      Gx_err = (short)(0) ;
   }

   private byte AV23parm_PerfilId ;
   private byte AV8PerfilId ;
   private byte AV20RolId ;
   private byte GXv_int3[] ;
   private byte GXv_int4[] ;
   private byte A1925PerfilId ;
   private short AV13EmpCod ;
   private short AV19SecUserId ;
   private short GXt_int1 ;
   private short AV15PaiCod ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV27LiqNro ;
   private long AV21MenuVerId ;
   private long GXv_int5[] ;
   private String scmdbuf ;
   private String AV17ConveCodigo ;
   private String AV29CliConvenio ;
   private String GXv_char6[] ;
   private String AV33Pgmname ;
   private java.util.Date AV25PeriodoLiq ;
   private boolean A1938MItemEsMenu ;
   private boolean AV9MItemEsMenu ;
   private boolean AV14existe ;
   private boolean GXv_boolean7[] ;
   private String AV22parm_MenuItemId ;
   private String AV18MenuOpcCod ;
   private String AV10URL ;
   private String AV11MenuItemId ;
   private String A1937MenuItemId ;
   private String AV28datos ;
   private String AV24MItemPadreDef ;
   private com.genexus.webpanels.WebSession AV26websession ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UP2_A1937MenuItemId ;
   private byte[] P01UP2_A1925PerfilId ;
   private boolean[] P01UP2_A1938MItemEsMenu ;
}

final  class getlinkmenu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UP2", "SELECT MenuItemId, PerfilId, MItemEsMenu FROM MenuItem WHERE PerfilId = ? and MenuItemId = ( ?) ORDER BY PerfilId, MenuItemId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40);
               return;
      }
   }

}

