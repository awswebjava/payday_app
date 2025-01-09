package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esconceptoimprimible extends GXProcedure
{
   public esconceptoimprimible( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esconceptoimprimible.class ), "" );
   }

   public esconceptoimprimible( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      esconceptoimprimible.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      esconceptoimprimible.this.AV9TipoConCod = aP0;
      esconceptoimprimible.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV9TipoConCod, "CAL_ARG") != 0 )
      {
         AV8esConceptoImprimible = true ;
      }
      else
      {
         AV8esConceptoImprimible = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = esconceptoimprimible.this.AV8esConceptoImprimible;
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
   private String AV9TipoConCod ;
   private boolean AV8esConceptoImprimible ;
   private boolean[] aP1 ;
}

