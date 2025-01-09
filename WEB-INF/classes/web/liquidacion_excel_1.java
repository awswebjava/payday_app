package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacion_excel_1", "/web.liquidacion_excel_1"})
public final  class liquidacion_excel_1 extends GXWebObjectStub
{
   public liquidacion_excel_1( )
   {
   }

   public liquidacion_excel_1( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacion_excel_1.class ));
   }

   public liquidacion_excel_1( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacion_excel_1_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacion_excel_1_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion_Excel_1";
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

