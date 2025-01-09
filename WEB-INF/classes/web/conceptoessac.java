package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoessac extends GXProcedure
{
   public conceptoessac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoessac.class ), "" );
   }

   public conceptoessac( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      conceptoessac.this.aP1 = new boolean[] {false};
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
      conceptoessac.this.AV8SubTipoConCod1 = aP0;
      conceptoessac.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( GXutil.strcmp(AV8SubTipoConCod1, new web.subtipocalculosac(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV8SubTipoConCod1, new web.subtiposac(remoteHandle, context).executeUdp( )) == 0 ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV9es = true ;
      }
      else
      {
         AV9es = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = conceptoessac.this.AV9es;
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
   private String AV8SubTipoConCod1 ;
   private boolean AV9es ;
   private boolean Cond_result ;
   private boolean[] aP1 ;
}

