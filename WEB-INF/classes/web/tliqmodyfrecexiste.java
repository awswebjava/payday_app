package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tliqmodyfrecexiste extends GXProcedure
{
   public tliqmodyfrecexiste( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tliqmodyfrecexiste.class ), "" );
   }

   public tliqmodyfrecexiste( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             boolean[] aP4 )
   {
      tliqmodyfrecexiste.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        boolean[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             boolean[] aP4 ,
                             String[] aP5 )
   {
      tliqmodyfrecexiste.this.AV12CliCod = aP0;
      tliqmodyfrecexiste.this.AV11TLiqCod = aP1;
      tliqmodyfrecexiste.this.AV10TLiqModTra = aP2;
      tliqmodyfrecexiste.this.AV9TLiqFrecPag = aP3;
      tliqmodyfrecexiste.this.aP4 = aP4;
      tliqmodyfrecexiste.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), AV11TLiqCod, AV10TLiqModTra, Byte.valueOf(AV9TLiqFrecPag)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2412TLiqFrecPag = P02LB2_A2412TLiqFrecPag[0] ;
         A2408TLiqModTra = P02LB2_A2408TLiqModTra[0] ;
         A32TLiqCod = P02LB2_A32TLiqCod[0] ;
         A3CliCod = P02LB2_A3CliCod[0] ;
         A2413TLiqDescAuxFrec = P02LB2_A2413TLiqDescAuxFrec[0] ;
         AV8existe = true ;
         AV13TLiqDescAuxFrec = A2413TLiqDescAuxFrec ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV17Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV17Pgmname, httpContext.getMessage( "&TLiqCod ", "")+GXutil.trim( AV11TLiqCod)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV17Pgmname, httpContext.getMessage( "&TLiqModTra ", "")+GXutil.trim( AV10TLiqModTra)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV17Pgmname, httpContext.getMessage( "&TLiqFrecPag ", "")+GXutil.trim( GXutil.str( AV9TLiqFrecPag, 1, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV17Pgmname, httpContext.getMessage( "&existe ", "")+GXutil.trim( GXutil.booltostr( AV8existe))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV17Pgmname, httpContext.getMessage( "&TLiqDescAuxFrec ", "")+GXutil.trim( AV13TLiqDescAuxFrec)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = tliqmodyfrecexiste.this.AV8existe;
      this.aP5[0] = tliqmodyfrecexiste.this.AV13TLiqDescAuxFrec;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13TLiqDescAuxFrec = "" ;
      scmdbuf = "" ;
      P02LB2_A2412TLiqFrecPag = new byte[1] ;
      P02LB2_A2408TLiqModTra = new String[] {""} ;
      P02LB2_A32TLiqCod = new String[] {""} ;
      P02LB2_A3CliCod = new int[1] ;
      P02LB2_A2413TLiqDescAuxFrec = new String[] {""} ;
      A2408TLiqModTra = "" ;
      A32TLiqCod = "" ;
      A2413TLiqDescAuxFrec = "" ;
      AV17Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tliqmodyfrecexiste__default(),
         new Object[] {
             new Object[] {
            P02LB2_A2412TLiqFrecPag, P02LB2_A2408TLiqModTra, P02LB2_A32TLiqCod, P02LB2_A3CliCod, P02LB2_A2413TLiqDescAuxFrec
            }
         }
      );
      AV17Pgmname = "tLiqModYFrecExiste" ;
      /* GeneXus formulas. */
      AV17Pgmname = "tLiqModYFrecExiste" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9TLiqFrecPag ;
   private byte A2412TLiqFrecPag ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private String AV11TLiqCod ;
   private String AV10TLiqModTra ;
   private String scmdbuf ;
   private String A2408TLiqModTra ;
   private String A32TLiqCod ;
   private String AV17Pgmname ;
   private boolean AV8existe ;
   private String AV13TLiqDescAuxFrec ;
   private String A2413TLiqDescAuxFrec ;
   private String[] aP5 ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P02LB2_A2412TLiqFrecPag ;
   private String[] P02LB2_A2408TLiqModTra ;
   private String[] P02LB2_A32TLiqCod ;
   private int[] P02LB2_A3CliCod ;
   private String[] P02LB2_A2413TLiqDescAuxFrec ;
}

final  class tliqmodyfrecexiste__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LB2", "SELECT TLiqFrecPag, TLiqModTra, TLiqCod, CliCod, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? and TLiqCod = ( ?) and TLiqModTra = ( ?) and TLiqFrecPag = ? ORDER BY CliCod, TLiqCod, TLiqModTra, TLiqFrecPag ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               return;
      }
   }

}

