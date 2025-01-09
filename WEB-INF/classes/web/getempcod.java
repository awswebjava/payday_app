package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempcod extends GXProcedure
{
   public getempcod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempcod.class ), "" );
   }

   public getempcod( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( )
   {
      getempcod.this.aP0 = new short[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( short[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short[] aP0 )
   {
      getempcod.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV10EmpCodPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.wwpbaseobjects.loaduserkeyvalue(remoteHandle, context).execute( httpContext.getMessage( "EmpCod", ""), 0, "", GXv_char2) ;
      getempcod.this.GXt_char1 = GXv_char2[0] ;
      AV10EmpCodPalabra = GXt_char1 ;
      AV8EmpCod = (short)(GXutil.lval( AV10EmpCodPalabra)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getempcod.this.AV8EmpCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10EmpCodPalabra = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short Gx_err ;
   private String AV10EmpCodPalabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private short[] aP0 ;
}

