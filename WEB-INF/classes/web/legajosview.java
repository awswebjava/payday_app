package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajosview", "/web.legajosview"})
public final  class legajosview extends GXWebObjectStub
{
   public legajosview( )
   {
   }

   public legajosview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajosview.class ));
   }

   public legajosview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajosview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajosview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajos View";
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
