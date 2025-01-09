package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getfrecpagosdemodo extends GXProcedure
{
   public getfrecpagosdemodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getfrecpagosdemodo.class ), "" );
   }

   public getfrecpagosdemodo( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Byte> executeUdp( int aP0 ,
                                               String aP1 )
   {
      getfrecpagosdemodo.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<Byte>(Byte.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXSimpleCollection<Byte>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXSimpleCollection<Byte>[] aP2 )
   {
      getfrecpagosdemodo.this.AV8CliCod = aP0;
      getfrecpagosdemodo.this.AV9tliqmodtra = aP1;
      getfrecpagosdemodo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9tliqmodtra});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2LC2 = false ;
         A3CliCod = P02LC2_A3CliCod[0] ;
         A2408TLiqModTra = P02LC2_A2408TLiqModTra[0] ;
         A2412TLiqFrecPag = P02LC2_A2412TLiqFrecPag[0] ;
         A32TLiqCod = P02LC2_A32TLiqCod[0] ;
         AV10tliqfrecpag.add((byte)(A2412TLiqFrecPag), 0);
         while ( (pr_default.getStatus(0) != 101) && ( P02LC2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P02LC2_A2408TLiqModTra[0], A2408TLiqModTra) == 0 ) && ( P02LC2_A2412TLiqFrecPag[0] == A2412TLiqFrecPag ) )
         {
            brk2LC2 = false ;
            A32TLiqCod = P02LC2_A32TLiqCod[0] ;
            brk2LC2 = true ;
            pr_default.readNext(0);
         }
         if ( ! brk2LC2 )
         {
            brk2LC2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getfrecpagosdemodo.this.AV10tliqfrecpag;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10tliqfrecpag = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      scmdbuf = "" ;
      P02LC2_A3CliCod = new int[1] ;
      P02LC2_A2408TLiqModTra = new String[] {""} ;
      P02LC2_A2412TLiqFrecPag = new byte[1] ;
      P02LC2_A32TLiqCod = new String[] {""} ;
      A2408TLiqModTra = "" ;
      A32TLiqCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getfrecpagosdemodo__default(),
         new Object[] {
             new Object[] {
            P02LC2_A3CliCod, P02LC2_A2408TLiqModTra, P02LC2_A2412TLiqFrecPag, P02LC2_A32TLiqCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A2412TLiqFrecPag ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9tliqmodtra ;
   private String scmdbuf ;
   private String A2408TLiqModTra ;
   private String A32TLiqCod ;
   private boolean brk2LC2 ;
   private GXSimpleCollection<Byte> AV10tliqfrecpag ;
   private GXSimpleCollection<Byte>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P02LC2_A3CliCod ;
   private String[] P02LC2_A2408TLiqModTra ;
   private byte[] P02LC2_A2412TLiqFrecPag ;
   private String[] P02LC2_A32TLiqCod ;
}

final  class getfrecpagosdemodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LC2", "SELECT CliCod, TLiqModTra, TLiqFrecPag, TLiqCod FROM TipoLiquidacionmodo_frec WHERE CliCod = ? and TLiqModTra = ( ?) ORDER BY CliCod, TLiqModTra, TLiqFrecPag ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
               stmt.setString(2, (String)parms[1], 1);
               return;
      }
   }

}

