package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenunucleo extends GXProcedure
{
   public inimenunucleo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenunucleo.class ), "" );
   }

   public inimenunucleo( int remoteHandle ,
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
      inimenunucleo.this.AV13RolId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12PerfilId = (byte)(1) ;
      AV11MenuVerId = 1 ;
      GXt_int1 = AV17EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      inimenunucleo.this.GXt_int1 = GXv_int2[0] ;
      AV17EmpCod = GXt_int1 ;
      GXt_int3 = AV18CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      inimenunucleo.this.GXt_int3 = GXv_int4[0] ;
      AV18CliCod = GXt_int3 ;
      new web.inimenucab(remoteHandle, context).execute( AV13RolId, AV12PerfilId, (short)(0), AV11MenuVerId) ;
      AV19SVGId = "" ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, "1") ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "General", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, true, (byte)(1), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, "2") ;
      AV15MenuOpcCod = httpContext.getMessage( "Clientes", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Religiones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Origenes", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(3), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de concepto", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(4), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Clasificaciones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(5), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de feriado", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(6), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de trabajo", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(7), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Países", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(8), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Roles", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(9), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Perfiles", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(10), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "SVGs", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(11), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Items de menú", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(12), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Menúes", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(13), httpContext.getMessage( "gear_50px", "")) ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = httpContext.getMessage( "AFIP", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(14), httpContext.getMessage( "gear_icono", "")) ;
      AV16MenuOpcPadre = AV15MenuOpcCod ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, "2") ;
      AV15MenuOpcCod = httpContext.getMessage( "Actividades", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(1), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Tipos de empleador", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(2), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Zonas", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(3), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Situaciones de revista", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(4), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Siniestrados", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(5), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Condiciones", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(6), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "Modalidades de contratación", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(7), httpContext.getMessage( "gear_50px", "")) ;
      AV15MenuOpcCod = httpContext.getMessage( "AFIPConcepto", "") ;
      AV20MenuItemId = AV15MenuOpcCod ;
      new web.newopcionmenu(remoteHandle, context).execute( AV13RolId, AV12PerfilId, AV11MenuVerId, AV15MenuOpcCod, AV19SVGId, "", AV20MenuItemId, AV16MenuOpcPadre, false, (byte)(8), httpContext.getMessage( "gear_50px", "")) ;
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
      AV19SVGId = "" ;
      AV25Pgmname = "" ;
      AV16MenuOpcPadre = "" ;
      AV15MenuOpcCod = "" ;
      AV20MenuItemId = "" ;
      AV25Pgmname = "iniMenuNucleo" ;
      /* GeneXus formulas. */
      AV25Pgmname = "iniMenuNucleo" ;
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
   private String AV19SVGId ;
   private String AV25Pgmname ;
   private String AV16MenuOpcPadre ;
   private String AV15MenuOpcCod ;
   private String AV20MenuItemId ;
}

