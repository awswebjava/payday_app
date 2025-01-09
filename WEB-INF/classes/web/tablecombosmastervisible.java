package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tablecombosmastervisible extends GXProcedure
{
   public tablecombosmastervisible( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tablecombosmastervisible.class ), "" );
   }

   public tablecombosmastervisible( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      tablecombosmastervisible.this.aP1 = new boolean[] {false};
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
      tablecombosmastervisible.this.AV8contentHolder_Pgmname = aP0;
      tablecombosmastervisible.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(GXutil.lower( GXutil.trim( AV8contentHolder_Pgmname)), httpContext.getMessage( "empresa_cabecera", "")) == 0 )
      {
         AV9visible = false ;
      }
      else
      {
         AV9visible = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = tablecombosmastervisible.this.AV9visible;
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
   private String AV8contentHolder_Pgmname ;
   private boolean AV9visible ;
   private boolean[] aP1 ;
}

