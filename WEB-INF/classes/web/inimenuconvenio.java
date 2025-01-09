package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenuconvenio extends GXProcedure
{
   public inimenuconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenuconvenio.class ), "" );
   }

   public inimenuconvenio( int remoteHandle ,
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
      inimenuconvenio.this.AV13RolId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12PerfilId = (byte)(3) ;
      AV11MenuVerId = 1 ;
      GXt_int1 = AV17EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      inimenuconvenio.this.GXt_int1 = GXv_int2[0] ;
      AV17EmpCod = GXt_int1 ;
      GXt_int3 = AV18CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      inimenuconvenio.this.GXt_int3 = GXv_int4[0] ;
      AV18CliCod = GXt_int3 ;
      new web.inimenucab(remoteHandle, context).execute( AV13RolId, AV12PerfilId, (short)(0), AV11MenuVerId) ;
      AV19SVGId = "" ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "1") ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Principal", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, true, (byte)(1), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "2") ;
      AV15MenuOpcCod = httpContext.getMessage( "Liberación de actualizaciones", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Convenios disponibles", "") ;
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
      AV21auxMenuOpcPadre = AV15MenuOpcCod ;
      AV15MenuOpcCod = httpContext.getMessage( "Fórmula", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV21auxMenuOpcPadre, false, (byte)(2), "") ;
      AV15MenuOpcCod = httpContext.getMessage( "Datos de convenio", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Importes de convenio", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Adicionales", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Opciones de adicional", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Importes de adicional", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Categorías", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Escalas salariales", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Actualizar tarifas categorías", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Vacaciones por antigüedad", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Fondo de cese laboral", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Licencias que cancelan adicionales", "") ;
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
      AV15MenuOpcCod = httpContext.getMessage( "Cálculos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Actualizaciones", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Reinicializar datos", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "Bases de cálculo", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      AV23MenuItemOrd = (byte)(0) ;
      AV15MenuOpcCod = httpContext.getMessage( "Convenio licencias jornal", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Convenio licencias mensual", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Convenio feriados jornal", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Convenio feriados mensual", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Convenio hora normal jornal", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Convenio hora normal mensual", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Convenio Horas extras", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15MenuOpcCod = httpContext.getMessage( "Convenio Horas extras extraordinarias", "") ;
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
      AV23MenuItemOrd = (byte)(AV23MenuItemOrd+1) ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, AV23MenuItemOrd, httpContext.getMessage( "gear_50px", "")) ;
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
      AV26Pgmname = "" ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = "" ;
      AV20MenuItemId = "" ;
      AV21auxMenuOpcPadre = "" ;
      AV26Pgmname = "iniMenuConvenio" ;
      /* GeneXus formulas. */
      AV26Pgmname = "iniMenuConvenio" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13RolId ;
   private byte AV12PerfilId ;
   private byte AV23MenuItemOrd ;
   private short AV17EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private long AV11MenuVerId ;
   private String AV19SVGId ;
   private String AV26Pgmname ;
   private String AV16MenuOpcPadre ;
   private String AV21auxMenuOpcPadre ;
   private boolean returnInSub ;
   private String AV15MenuOpcCod ;
   private String AV20MenuItemId ;
}

