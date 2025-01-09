package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clientecct_fondocesegeneral", "/web.clientecct_fondocesegeneral"})
public final  class clientecct_fondocesegeneral extends GXWebObjectStub
{
   public clientecct_fondocesegeneral( )
   {
   }

   public clientecct_fondocesegeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientecct_fondocesegeneral.class ));
   }

   public clientecct_fondocesegeneral( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientecct_fondocesegeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientecct_fondocesegeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Clientecct_fondocese General";
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

