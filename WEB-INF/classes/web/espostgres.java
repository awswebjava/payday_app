package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class espostgres extends GXProcedure
{
   public espostgres( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( espostgres.class ), "" );
   }

   public espostgres( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 )
   {
      espostgres.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             boolean[] aP1 )
   {
      espostgres.this.AV9clicod = aP0;
      espostgres.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8es = true ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = espostgres.this.AV8es;
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
   private boolean AV8es ;
   private boolean[] aP1 ;
}

