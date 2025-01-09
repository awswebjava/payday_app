package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptoafipview", "/web.conceptoafipview"})
public final  class conceptoafipview extends GXWebObjectStub
{
   public conceptoafipview( )
   {
   }

   public conceptoafipview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptoafipview.class ));
   }

   public conceptoafipview( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptoafipview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptoafipview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto AFIPView";
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

