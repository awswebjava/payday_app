package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getfilterval extends GXProcedure
{
   public wwp_getfilterval( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getfilterval.class ), "" );
   }

   public wwp_getfilterval( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( boolean aP0 ,
                             String aP1 )
   {
      wwp_getfilterval.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( boolean aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( boolean aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      wwp_getfilterval.this.AV10IsEmpty = aP0;
      wwp_getfilterval.this.AV9FilterValue = aP1;
      wwp_getfilterval.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! AV10IsEmpty )
      {
         AV8FilterResult = GXutil.strReplace( GXutil.strReplace( AV9FilterValue, "\\", "\\\\"), "|", "\\|") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = wwp_getfilterval.this.AV8FilterResult;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8FilterResult = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV10IsEmpty ;
   private String AV9FilterValue ;
   private String AV8FilterResult ;
   private String[] aP2 ;
}

