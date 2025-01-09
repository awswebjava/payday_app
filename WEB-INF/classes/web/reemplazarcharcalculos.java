package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reemplazarcharcalculos extends GXProcedure
{
   public reemplazarcharcalculos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reemplazarcharcalculos.class ), "" );
   }

   public reemplazarcharcalculos( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      reemplazarcharcalculos.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      reemplazarcharcalculos.this.AV9clicod = aP0;
      reemplazarcharcalculos.this.AV8OpeCodFormula = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8OpeCodFormula = GXutil.strReplace( AV8OpeCodFormula, "[", "{") ;
      AV8OpeCodFormula = GXutil.strReplace( AV8OpeCodFormula, "]", "}") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = reemplazarcharcalculos.this.AV8OpeCodFormula;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9clicod ;
   private String AV8OpeCodFormula ;
   private String[] aP1 ;
}

