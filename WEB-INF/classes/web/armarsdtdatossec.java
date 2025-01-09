package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armarsdtdatossec extends GXProcedure
{
   public armarsdtdatossec( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armarsdtdatossec.class ), "" );
   }

   public armarsdtdatossec( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.Sdtsdt_datos_sec executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           GXSimpleCollection<Integer> aP3 ,
                                           String aP4 ,
                                           String aP5 ,
                                           String aP6 )
   {
      armarsdtdatossec.this.aP7 = new web.Sdtsdt_datos_sec[] {new web.Sdtsdt_datos_sec()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        web.Sdtsdt_datos_sec[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             web.Sdtsdt_datos_sec[] aP7 )
   {
      armarsdtdatossec.this.AV9CliCod = aP0;
      armarsdtdatossec.this.AV12EmpCod = aP1;
      armarsdtdatossec.this.AV8LiqNro = aP2;
      armarsdtdatossec.this.AV13LegNumero = aP3;
      armarsdtdatossec.this.AV14LiqLote = aP4;
      armarsdtdatossec.this.AV11ClientId = aP5;
      armarsdtdatossec.this.AV15ejecutarSolo = aP6;
      armarsdtdatossec.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10sdt_datos_sec.setgxTv_Sdtsdt_datos_sec_Clicod( AV9CliCod );
      AV10sdt_datos_sec.setgxTv_Sdtsdt_datos_sec_Clientid( AV11ClientId );
      AV10sdt_datos_sec.setgxTv_Sdtsdt_datos_sec_Empcod( AV12EmpCod );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new web.getmetaparmvalue(remoteHandle, context).execute( httpContext.getMessage( "env", ""), GXv_char2) ;
      armarsdtdatossec.this.GXt_char1 = GXv_char2[0] ;
      AV10sdt_datos_sec.setgxTv_Sdtsdt_datos_sec_Env( GXt_char1 );
      AV10sdt_datos_sec.getgxTv_Sdtsdt_datos_sec_Legnumero().fromJSonString(AV13LegNumero.toJSonString(false), null);
      AV10sdt_datos_sec.setgxTv_Sdtsdt_datos_sec_Liqlote( AV14LiqLote );
      AV10sdt_datos_sec.setgxTv_Sdtsdt_datos_sec_Liqnro( AV8LiqNro );
      AV10sdt_datos_sec.setgxTv_Sdtsdt_datos_sec_Ejecutarsolo( AV15ejecutarSolo );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = armarsdtdatossec.this.AV10sdt_datos_sec;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10sdt_datos_sec = new web.Sdtsdt_datos_sec(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV8LiqNro ;
   private String AV15ejecutarSolo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV14LiqLote ;
   private String AV11ClientId ;
   private GXSimpleCollection<Integer> AV13LegNumero ;
   private web.Sdtsdt_datos_sec[] aP7 ;
   private web.Sdtsdt_datos_sec AV10sdt_datos_sec ;
}

