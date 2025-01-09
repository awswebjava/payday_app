package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class guardarnavegacion extends GXProcedure
{
   public guardarnavegacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( guardarnavegacion.class ), "" );
   }

   public guardarnavegacion( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      guardarnavegacion.this.AV10URL = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12aux_sdt_nav.fromJSonString(AV8websession.getValue(httpContext.getMessage( "navegacion", "")), null);
      if ( AV12aux_sdt_nav.size() > 0 )
      {
         AV11item = (web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem)new web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem(remoteHandle, context);
         AV11item.setgxTv_Sdtsdt_nav_sdt_navItem_Url( ((web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem)AV12aux_sdt_nav.elementAt(-1+AV12aux_sdt_nav.size())).getgxTv_Sdtsdt_nav_sdt_navItem_Url() );
         AV9sdt_nav.add(AV11item, 0);
      }
      AV11item = (web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem)new web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem(remoteHandle, context);
      AV11item.setgxTv_Sdtsdt_nav_sdt_navItem_Url( AV10URL );
      AV9sdt_nav.add(AV11item, 0);
      AV8websession.setValue(httpContext.getMessage( "navegacion", ""), AV9sdt_nav.toJSonString(false));
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
      AV12aux_sdt_nav = new GXBaseCollection<web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem>(web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem.class, "sdt_navItem", "PayDay", remoteHandle);
      AV8websession = httpContext.getWebSession();
      AV11item = new web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem(remoteHandle, context);
      AV9sdt_nav = new GXBaseCollection<web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem>(web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem.class, "sdt_navItem", "PayDay", remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10URL ;
   private com.genexus.webpanels.WebSession AV8websession ;
   private GXBaseCollection<web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem> AV12aux_sdt_nav ;
   private GXBaseCollection<web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem> AV9sdt_nav ;
   private web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem AV11item ;
}

