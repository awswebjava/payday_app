package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenuusuario extends GXProcedure
{
   public inimenuusuario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenuusuario.class ), "" );
   }

   public inimenuusuario( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( byte aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( byte aP0 )
   {
      inimenuusuario.this.AV13RolId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12PerfilId = (byte)(4) ;
      AV11MenuVerId = 1 ;
      GXt_int1 = AV17EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      inimenuusuario.this.GXt_int1 = GXv_int2[0] ;
      AV17EmpCod = GXt_int1 ;
      GXt_int3 = AV18CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      inimenuusuario.this.GXt_int3 = GXv_int4[0] ;
      AV18CliCod = GXt_int3 ;
      new web.inimenucab(remoteHandle, context).execute( AV13RolId, AV12PerfilId, new web.paisargentina(remoteHandle, context).executeUdp( ), AV11MenuVerId) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "1") ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Liquidación", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, true, (byte)(1), "") ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "2") ;
      AV19SVGId = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Conceptos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "conceptos", "")) ;
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Fórmula", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(2), "") ;
      AV15MenuOpcCod = httpContext.getMessage( "Periodos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "liquidaciones", "")) ;
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Liquidaciones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(2), "") ;
      AV22aux2MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "LiquidacionLSD", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(2), "") ;
      AV15MenuOpcCod = httpContext.getMessage( "LiquidacionLegajo", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(2), "") ;
      AV23aux3MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "LiquidacionRecibo", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV23aux3MenuOpcPadre, false, (byte)(2), "") ;
      AV15MenuOpcCod = httpContext.getMessage( "LiquidacionAjustes", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV23aux3MenuOpcPadre, false, (byte)(2), "") ;
      AV15MenuOpcCod = httpContext.getMessage( "PeriodoLSD", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(2), "") ;
      AV15MenuOpcCod = httpContext.getMessage( "Exportar liquidaciones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(3), httpContext.getMessage( "informe", "")) ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Nómina", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "legajos50", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Legajos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "legajos50", "")) ;
      AV27Menuopcpadre2 = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "LegajoINS", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV27Menuopcpadre2, false, (byte)(1), httpContext.getMessage( "legajos50", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "LegajoUPD", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV27Menuopcpadre2, false, (byte)(1), httpContext.getMessage( "legajos50", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "LegajoDLT", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV27Menuopcpadre2, false, (byte)(1), httpContext.getMessage( "legajos50", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "LegajoDSP", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV27Menuopcpadre2, false, (byte)(1), httpContext.getMessage( "legajos50", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Ajuste de sueldos por inflación", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "legajos50", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Cuenta corriente de vacaciones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "legajos50", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Egresos / Permanencias", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, httpContext.getMessage( "Antiguedad / Permanencias", ""), AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "legajos50", "")) ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Novedades", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(3), httpContext.getMessage( "horas_y_adicionales", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Horas trabajadas y conceptos adicionales", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "horas_y_adicionales", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Faltas y llegadas tarde", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "faltas_y_tardes_img", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Vacaciones y licencias", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(3), httpContext.getMessage( "licencias_y_vacaciones", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Deducciones y reintegros", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(4), httpContext.getMessage( "deducciones_y_reintegros", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Obligaciones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, httpContext.getMessage( "Cuotas descuentos y acreditaciones", ""), AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(5), httpContext.getMessage( "obligaciones_img", "")) ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Reportes", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(4), httpContext.getMessage( "informe", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Reporte", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "informe", "")) ;
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Configuración", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(5), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Empresa", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "empresas", "")) ;
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Datos principales", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "empresas", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "EmpBancos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(2), httpContext.getMessage( "gear_50px", "")) ;
      AV22aux2MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Bases de cálculo", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(2), httpContext.getMessage( "gear_50px", "")) ;
      AV22aux2MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "EmpBaseCal clase jornal", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV23aux3MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Licencias en clase jornal", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV23aux3MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Feriados en clase jornal", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV23aux3MenuOpcPadre, false, (byte)(3), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Hora normal en clase jornal", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV23aux3MenuOpcPadre, false, (byte)(5), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "EmpBaseCal clase mensual", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV23aux3MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Licencias en clase mensual", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV23aux3MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Feriados en clase mensual", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV23aux3MenuOpcPadre, false, (byte)(4), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Hora normal en clase mensual", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV23aux3MenuOpcPadre, false, (byte)(6), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Horas extras", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(3), httpContext.getMessage( "gear_50px", "")) ;
      AV22aux2MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Horas extras extraordinarias", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(4), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Otros", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(5), httpContext.getMessage( "gear_50px", "")) ;
      AV22aux2MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "ReligionesEmpresa", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "OrigenesEmpresa", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Convenios", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "convenio_img", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Conceptos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(3), httpContext.getMessage( "conceptos", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Componentes de fórmula", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(4), "") ;
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Cálculos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(4), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Variables", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(4), httpContext.getMessage( "gear_50px", "")) ;
      AV22aux2MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Valores", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(4), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Usuarios", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(5), httpContext.getMessage( "userProfile_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Bancos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(6), httpContext.getMessage( "bancos", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Obras sociales", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(7), httpContext.getMessage( "obras_sociales", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Sindicatos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(8), httpContext.getMessage( "sindicatos", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Áreas", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(9), httpContext.getMessage( "secciones", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Puestos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(10), httpContext.getMessage( "secciones", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Motivos de egreso", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(11), httpContext.getMessage( "motivodeegreso", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Parámetros", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(12), httpContext.getMessage( "gear_50px", "")) ;
      if ( AV13RolId == 1 )
      {
         AV15MenuOpcCod = httpContext.getMessage( "Parámetros backend", "") ;
         AV20MenuItemId = AV15MenuOpcCod ;
         new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(12), httpContext.getMessage( "gear_50px", "")) ;
         AV15MenuOpcCod = httpContext.getMessage( "Parámetros todos", "") ;
         AV20MenuItemId = AV15MenuOpcCod ;
         new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(12), httpContext.getMessage( "gear_50px", "")) ;
         AV15MenuOpcCod = httpContext.getMessage( "Conexiones SOAP", "") ;
         AV20MenuItemId = AV15MenuOpcCod ;
         new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(12), httpContext.getMessage( "gear_50px", "")) ;
         AV15MenuOpcCod = httpContext.getMessage( "Conexiones REST", "") ;
         AV20MenuItemId = AV15MenuOpcCod ;
         new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(12), httpContext.getMessage( "gear_50px", "")) ;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Impuesto a las ganancias", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(14), httpContext.getMessage( "gear_50px", "")) ;
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Tratamientos de exención IIGG", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Condiciones de exención", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(2), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Códigos SIRADIG", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(3), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Parámetros país", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(14), httpContext.getMessage( "gear_50px", "")) ;
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Provincias", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Localidades", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Agenda de feriados", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Estados / Licencias", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Embargabilidad", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de obligación", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Sexos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Estados civiles", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "A.R.T.", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "AFIP_Tablas", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV22aux2MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Situaciones de revista", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Actividades", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de empleador", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Zonas", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Siniestrados", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Condiciones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Modalidades de contratación", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "AFIPConcepto", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV22aux2MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Importación", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(6), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Importar legajos", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "importar_legajos", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Importar liquidaciones históricas", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "importar_liquidaciones", "")) ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Actualizaciones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(7), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "AFIP", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(8), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Libro de Sueldos Digital", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "Libro_sueldo_digital", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Formulario 1357", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "formulario_1357", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Deducciones y reintegros", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(3), httpContext.getMessage( "deducciones_y_reintegros", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV26Pgmname = "" ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = "" ;
      AV20MenuItemId = "" ;
      AV19SVGId = "" ;
      AV21auxMenuOpcPadre = "" ;
      AV22aux2MenuOpcPadre = "" ;
      AV23aux3MenuOpcPadre = "" ;
      AV27Menuopcpadre2 = "" ;
      AV26Pgmname = "iniMenuUsuario" ;
      /* GeneXus formulas. */
      AV26Pgmname = "iniMenuUsuario" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13RolId ;
   private byte AV12PerfilId ;
   private short AV17EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private long AV11MenuVerId ;
   private String AV26Pgmname ;
   private String AV16MenuOpcPadre ;
   private String AV19SVGId ;
   private String AV21auxMenuOpcPadre ;
   private String AV22aux2MenuOpcPadre ;
   private String AV23aux3MenuOpcPadre ;
   private String AV15MenuOpcCod ;
   private String AV20MenuItemId ;
   private String AV27Menuopcpadre2 ;
}

