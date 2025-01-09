package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabasesionformula extends GXProcedure
{
   public grabasesionformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabasesionformula.class ), "" );
   }

   public grabasesionformula( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String aP2 )
   {
      grabasesionformula.this.AV9LiqNro = aP0;
      grabasesionformula.this.AV10LegNumero = aP1;
      grabasesionformula.this.AV11ConFormula = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (0==AV9LiqNro) )
      {
         AV8WebSession.setValue(httpContext.getMessage( "formula_LiqNro", ""), GXutil.str( AV9LiqNro, 8, 0));
      }
      if ( ! (0==AV10LegNumero) )
      {
         AV8WebSession.setValue(httpContext.getMessage( "formula_LegNumero", ""), GXutil.str( AV10LegNumero, 8, 0));
      }
      if ( GXutil.strcmp(AV11ConFormula, httpContext.getMessage( "remove", "")) == 0 )
      {
         AV8WebSession.remove(httpContext.getMessage( "formula_ConFormula", ""));
      }
      else
      {
         AV8WebSession.setValue(httpContext.getMessage( "formula_ConFormula", ""), GXutil.trim( AV11ConFormula));
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8WebSession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private String AV11ConFormula ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
}

