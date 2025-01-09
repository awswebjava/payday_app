package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.abmconcepto", "/web.abmconcepto"})
public final  class abmconcepto extends GXWebObjectStub
{
   public abmconcepto( )
   {
   }

   public abmconcepto( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( abmconcepto.class ));
   }

   public abmconcepto( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new abmconcepto_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new abmconcepto_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo";
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

