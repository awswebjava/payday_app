package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnexthis extends GXProcedure
{
   public getnexthis( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnexthis.class ), "" );
   }

   public getnexthis( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 )
   {
      getnexthis.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             short[] aP1 )
   {
      getnexthis.this.AV8ConCodigo = aP0;
      getnexthis.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV9ForHisNum ;
      new web.getulthis(remoteHandle, context).execute( AV8ConCodigo, GXv_int1) ;
      getnexthis.this.AV9ForHisNum = GXv_int1[0] ;
      AV9ForHisNum = (short)(AV9ForHisNum+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getnexthis.this.AV9ForHisNum;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9ForHisNum ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private String AV8ConCodigo ;
   private short[] aP1 ;
}

