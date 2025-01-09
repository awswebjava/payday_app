package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpuestodearealikedescrip extends GXProcedure
{
   public getpuestodearealikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpuestodearealikedescrip.class ), "" );
   }

   public getpuestodearealikedescrip( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String[] aP3 )
   {
      getpuestodearealikedescrip.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      getpuestodearealikedescrip.this.AV11CliCod = aP0;
      getpuestodearealikedescrip.this.AV12SecCodigo = aP1;
      getpuestodearealikedescrip.this.AV8PuestoDescrip = aP2;
      getpuestodearealikedescrip.this.aP3 = aP3;
      getpuestodearealikedescrip.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV8PuestoDescrip = GXutil.concat( GXutil.rtrim( AV8PuestoDescrip), "%", "") ;
      /* Using cursor P025S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV12SecCodigo, lV8PuestoDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1242PuestoDescripSinAc = P025S2_A1242PuestoDescripSinAc[0] ;
         A13SecCodigo = P025S2_A13SecCodigo[0] ;
         A3CliCod = P025S2_A3CliCod[0] ;
         A1240PuestoCodigo = P025S2_A1240PuestoCodigo[0] ;
         AV10PuestoCodigo = A1240PuestoCodigo ;
         AV9existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getpuestodearealikedescrip.this.AV10PuestoCodigo;
      this.aP4[0] = getpuestodearealikedescrip.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10PuestoCodigo = "" ;
      lV8PuestoDescrip = "" ;
      scmdbuf = "" ;
      P025S2_A1242PuestoDescripSinAc = new String[] {""} ;
      P025S2_A13SecCodigo = new String[] {""} ;
      P025S2_A3CliCod = new int[1] ;
      P025S2_A1240PuestoCodigo = new String[] {""} ;
      A1242PuestoDescripSinAc = "" ;
      A13SecCodigo = "" ;
      A1240PuestoCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpuestodearealikedescrip__default(),
         new Object[] {
             new Object[] {
            P025S2_A1242PuestoDescripSinAc, P025S2_A13SecCodigo, P025S2_A3CliCod, P025S2_A1240PuestoCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV12SecCodigo ;
   private String AV10PuestoCodigo ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
   private boolean AV9existe ;
   private String AV8PuestoDescrip ;
   private String lV8PuestoDescrip ;
   private String A1242PuestoDescripSinAc ;
   private boolean[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P025S2_A1242PuestoDescripSinAc ;
   private String[] P025S2_A13SecCodigo ;
   private int[] P025S2_A3CliCod ;
   private String[] P025S2_A1240PuestoCodigo ;
}

final  class getpuestodearealikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025S2", "SELECT PuestoDescripSinAc, SecCodigo, CliCod, PuestoCodigo FROM Puesto WHERE (CliCod = ? and SecCodigo = ( ?)) AND (PuestoDescripSinAc like '%' || ?) ORDER BY CliCod, SecCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400);
               return;
      }
   }

}

