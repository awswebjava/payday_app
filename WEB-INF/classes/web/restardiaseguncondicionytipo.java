package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class restardiaseguncondicionytipo extends GXProcedure
{
   public restardiaseguncondicionytipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( restardiaseguncondicionytipo.class ), "" );
   }

   public restardiaseguncondicionytipo( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              String aP2 )
   {
      restardiaseguncondicionytipo.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean[] aP3 )
   {
      restardiaseguncondicionytipo.this.AV8DConCondicion = aP0;
      restardiaseguncondicionytipo.this.AV9DTipoConCod = aP1;
      restardiaseguncondicionytipo.this.AV10DSubTipoConCod1 = aP2;
      restardiaseguncondicionytipo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11restar = false ;
      GXv_boolean1[0] = AV11restar ;
      new web.getcondrestadias(remoteHandle, context).execute( AV8DConCondicion, GXv_boolean1) ;
      restardiaseguncondicionytipo.this.AV11restar = GXv_boolean1[0] ;
      if ( AV11restar )
      {
         GXv_boolean1[0] = AV11restar ;
         new web.getsubtrestadias(remoteHandle, context).execute( AV9DTipoConCod, AV10DSubTipoConCod1, GXv_boolean1) ;
         restardiaseguncondicionytipo.this.AV11restar = GXv_boolean1[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = restardiaseguncondicionytipo.this.AV11restar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_boolean1 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8DConCondicion ;
   private String AV9DTipoConCod ;
   private String AV10DSubTipoConCod1 ;
   private boolean AV11restar ;
   private boolean GXv_boolean1[] ;
   private boolean[] aP3 ;
}

