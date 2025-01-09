package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.operandogeneral", "/web.operandogeneral"})
public final  class operandogeneral extends GXWebObjectStub
{
   public operandogeneral( )
   {
   }

   public operandogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( operandogeneral.class ));
   }

   public operandogeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new operandogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new operandogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Operando General";
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

