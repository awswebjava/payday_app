package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.listmoduleitems", "/web.listmoduleitems"})
public final  class listmoduleitems extends GXWebObjectStub
{
   public listmoduleitems( )
   {
   }

   public listmoduleitems( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( listmoduleitems.class ));
   }

   public listmoduleitems( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(web.GXcfg.class);
      web.listmoduleitems_impl pgm = new web.listmoduleitems_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new listmoduleitems_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new listmoduleitems_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "List Module Items";
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
      return "SESSION";
   }

}

