package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptoformulahistoricowc", "/web.conceptoformulahistoricowc"})
public final  class conceptoformulahistoricowc extends GXWebObjectStub
{
   public conceptoformulahistoricowc( )
   {
   }

   public conceptoformulahistoricowc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptoformulahistoricowc.class ));
   }

   public conceptoformulahistoricowc( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptoformulahistoricowc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptoformulahistoricowc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto Formula Historico WC";
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

