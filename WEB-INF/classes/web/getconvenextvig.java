package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvenextvig extends GXProcedure
{
   public getconvenextvig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvenextvig.class ), "" );
   }

   public getconvenextvig( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     String aP2 )
   {
      getconvenextvig.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date[] aP3 )
   {
      getconvenextvig.this.AV12CliCod = aP0;
      getconvenextvig.this.AV11CliPaiConve = aP1;
      getconvenextvig.this.AV8CliConvenio = aP2;
      getconvenextvig.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_date1[0] = AV9CatVigencia ;
      GXv_int2[0] = AV10CatFrecAct ;
      new web.getconveultivig(remoteHandle, context).execute( AV12CliCod, AV11CliPaiConve, AV8CliConvenio, AV13nulaFecha, GXv_date1, GXv_int2) ;
      getconvenextvig.this.AV9CatVigencia = GXv_date1[0] ;
      getconvenextvig.this.AV10CatFrecAct = GXv_int2[0] ;
      AV9CatVigencia = GXutil.addmth( AV9CatVigencia, AV10CatFrecAct) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getconvenextvig.this.AV9CatVigencia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9CatVigencia = GXutil.nullDate() ;
      AV13nulaFecha = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      GXv_int2 = new byte[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10CatFrecAct ;
   private byte GXv_int2[] ;
   private short AV11CliPaiConve ;
   private short Gx_err ;
   private int AV12CliCod ;
   private String AV8CliConvenio ;
   private java.util.Date AV9CatVigencia ;
   private java.util.Date AV13nulaFecha ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date[] aP3 ;
}

