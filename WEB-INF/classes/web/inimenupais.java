package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenupais extends GXProcedure
{
   public inimenupais( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenupais.class ), "" );
   }

   public inimenupais( int remoteHandle ,
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
      inimenupais.this.AV13RolId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12PerfilId = (byte)(2) ;
      AV11MenuVerId = 1 ;
      GXt_int1 = AV17EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      inimenupais.this.GXt_int1 = GXv_int2[0] ;
      AV17EmpCod = GXt_int1 ;
      GXt_int3 = AV18CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      inimenupais.this.GXt_int3 = GXv_int4[0] ;
      AV18CliCod = GXt_int3 ;
      new web.inimenucab(remoteHandle, context).execute( AV13RolId, AV12PerfilId, (short)(0), AV11MenuVerId) ;
      AV19SVGId = "" ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "1") ;
      AV23MenuItemOrd = (byte)(2) ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Configuración", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, true, (byte)(1), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "2") ;
      AV15MenuOpcCod = httpContext.getMessage( "Conceptos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Fórmula", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(2), "") ;
      AV15MenuOpcCod = httpContext.getMessage( "Condiciones concepto", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Bancos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Obras sociales", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Areas", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de feriado", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Puestos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Motivos de egreso", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Estados", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Parámetros", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Parámetros backend", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Parámetros todos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Variables", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Valores", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Template recibos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Tratamientos de exención IIGG", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Condiciones de exención", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Códigos SIRADIG", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Embargabilidad", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de obligación", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de liquidación", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Clientes", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Parentescos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Conceptos exportar", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Liberación de actualizaciones", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Conceptos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Sexos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Estados civiles", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de feriado", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Feriados", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Agenda de feriados", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Datos de país", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "manda País licencias jornal", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "País licencias jornal", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "País licencias mensual", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "País feriados jornal", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "País feriados mensual", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "País hora normal jornal", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "País hora normal mensual", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "País Horas extras", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "País Horas extras extraordinarias", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Adicionales reservados", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Provincias", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Localidades", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "A.R.T.", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Sindicatos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "PaisConvenios", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Vacaciones", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Cálculos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'NEW' Routine */
      returnInSub = false ;
      AV20MenuItemId = AV15MenuOpcCod ;
      if ( GXutil.strcmp(AV15MenuOpcCod, httpContext.getMessage( "Liberación de actualizaciones", "")) == 0 )
      {
         AV24auxMenuItemOrd = (byte)(1) ;
      }
      else
      {
         AV23MenuItemOrd = (byte)(AV23MenuItemOrd+1) ;
         AV24auxMenuItemOrd = AV23MenuItemOrd ;
      }
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, AV24auxMenuItemOrd, httpContext.getMessage( "gear_50px", "")) ;
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
      AV19SVGId = "" ;
      AV27Pgmname = "" ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = "" ;
      AV20MenuItemId = "" ;
      AV21auxMenuOpcPadre = "" ;
      AV27Pgmname = "iniMenuPais" ;
      /* GeneXus formulas. */
      AV27Pgmname = "iniMenuPais" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13RolId ;
   private byte AV12PerfilId ;
   private byte AV23MenuItemOrd ;
   private byte AV24auxMenuItemOrd ;
   private short AV17EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private long AV11MenuVerId ;
   private String AV19SVGId ;
   private String AV27Pgmname ;
   private String AV16MenuOpcPadre ;
   private String AV21auxMenuOpcPadre ;
   private boolean returnInSub ;
   private String AV15MenuOpcCod ;
   private String AV20MenuItemId ;
}

