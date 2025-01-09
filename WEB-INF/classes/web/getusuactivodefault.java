package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getusuactivodefault extends GXProcedure
{
   public getusuactivodefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getusuactivodefault.class ), "" );
   }

   public getusuactivodefault( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( )
   {
      getusuactivodefault.this.aP0 = new boolean[] {false};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( boolean[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( boolean[] aP0 )
   {
      getusuactivodefault.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV9SecUsuActivo ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.eslocalhost(remoteHandle, context).execute( GXv_boolean2) ;
      getusuactivodefault.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV9SecUsuActivo = GXt_boolean1 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getusuactivodefault.this.AV9SecUsuActivo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_boolean2 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV9SecUsuActivo ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean[] aP0 ;
}

