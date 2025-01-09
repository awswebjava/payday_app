package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionverdetalle2", "/web.liquidacionverdetalle2"})
public final  class liquidacionverdetalle2 extends GXWebObjectStub
{
   public liquidacionverdetalle2( )
   {
   }

   public liquidacionverdetalle2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionverdetalle2.class ));
   }

   public liquidacionverdetalle2( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionverdetalle2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionverdetalle2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Conceptos de la Liquidación";
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

