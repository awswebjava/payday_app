package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.afipconceptoview", "/web.afipconceptoview"})
public final  class afipconceptoview extends GXWebObjectStub
{
   public afipconceptoview( )
   {
   }

   public afipconceptoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( afipconceptoview.class ));
   }

   public afipconceptoview( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new afipconceptoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new afipconceptoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "AFIPConcepto View";
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

