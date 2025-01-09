package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.menu", "/web.menu"})
public final  class menu extends GXWebObjectStub
{
   public menu( )
   {
   }

   public menu( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( menu.class ));
   }

   public menu( int remoteHandle ,
                ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(web.GXcfg.class);
      web.menu_impl pgm = new web.menu_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new menu_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new menu_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Menu";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

