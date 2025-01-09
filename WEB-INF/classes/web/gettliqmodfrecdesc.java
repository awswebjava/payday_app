package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettliqmodfrecdesc extends GXProcedure
{
   public gettliqmodfrecdesc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettliqmodfrecdesc.class ), "" );
   }

   public gettliqmodfrecdesc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 )
   {
      gettliqmodfrecdesc.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             String[] aP4 )
   {
      gettliqmodfrecdesc.this.AV12CliCod = aP0;
      gettliqmodfrecdesc.this.AV11TLiqCod = aP1;
      gettliqmodfrecdesc.this.AV10TLiqModTra = aP2;
      gettliqmodfrecdesc.this.AV9TLiqFrecPag = aP3;
      gettliqmodfrecdesc.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02L42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), AV11TLiqCod, AV10TLiqModTra, Byte.valueOf(AV9TLiqFrecPag)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2412TLiqFrecPag = P02L42_A2412TLiqFrecPag[0] ;
         A2408TLiqModTra = P02L42_A2408TLiqModTra[0] ;
         A32TLiqCod = P02L42_A32TLiqCod[0] ;
         A3CliCod = P02L42_A3CliCod[0] ;
         A2413TLiqDescAuxFrec = P02L42_A2413TLiqDescAuxFrec[0] ;
         AV8TLiqDescAuxFrec = A2413TLiqDescAuxFrec ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = gettliqmodfrecdesc.this.AV8TLiqDescAuxFrec;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8TLiqDescAuxFrec = "" ;
      scmdbuf = "" ;
      P02L42_A2412TLiqFrecPag = new byte[1] ;
      P02L42_A2408TLiqModTra = new String[] {""} ;
      P02L42_A32TLiqCod = new String[] {""} ;
      P02L42_A3CliCod = new int[1] ;
      P02L42_A2413TLiqDescAuxFrec = new String[] {""} ;
      A2408TLiqModTra = "" ;
      A32TLiqCod = "" ;
      A2413TLiqDescAuxFrec = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettliqmodfrecdesc__default(),
         new Object[] {
             new Object[] {
            P02L42_A2412TLiqFrecPag, P02L42_A2408TLiqModTra, P02L42_A32TLiqCod, P02L42_A3CliCod, P02L42_A2413TLiqDescAuxFrec
            }
         }
      );
      /* GeneXus formulas. */
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
   private String AV8TLiqDescAuxFrec ;
   private String A2413TLiqDescAuxFrec ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P02L42_A2412TLiqFrecPag ;
   private String[] P02L42_A2408TLiqModTra ;
   private String[] P02L42_A32TLiqCod ;
   private int[] P02L42_A3CliCod ;
   private String[] P02L42_A2413TLiqDescAuxFrec ;
}

final  class gettliqmodfrecdesc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02L42", "SELECT TLiqFrecPag, TLiqModTra, TLiqCod, CliCod, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? and TLiqCod = ( ?) and TLiqModTra = ( ?) and TLiqFrecPag = ? ORDER BY CliCod, TLiqCod, TLiqModTra, TLiqFrecPag ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

