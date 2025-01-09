package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getareapuestopordescrip extends GXProcedure
{
   public getareapuestopordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getareapuestopordescrip.class ), "" );
   }

   public getareapuestopordescrip( int remoteHandle ,
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
      getareapuestopordescrip.this.aP4 = new boolean[] {false};
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
      getareapuestopordescrip.this.AV10CliCod = aP0;
      getareapuestopordescrip.this.AV8SecCodigo = aP1;
      getareapuestopordescrip.this.AV9PuestoDescrip = aP2;
      getareapuestopordescrip.this.aP3 = aP3;
      getareapuestopordescrip.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025L2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8SecCodigo, AV9PuestoDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1242PuestoDescripSinAc = P025L2_A1242PuestoDescripSinAc[0] ;
         A13SecCodigo = P025L2_A13SecCodigo[0] ;
         A3CliCod = P025L2_A3CliCod[0] ;
         A1240PuestoCodigo = P025L2_A1240PuestoCodigo[0] ;
         AV11PuestoCodigo = A1240PuestoCodigo ;
         AV12existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getareapuestopordescrip.this.AV11PuestoCodigo;
      this.aP4[0] = getareapuestopordescrip.this.AV12existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11PuestoCodigo = "" ;
      scmdbuf = "" ;
      P025L2_A1242PuestoDescripSinAc = new String[] {""} ;
      P025L2_A13SecCodigo = new String[] {""} ;
      P025L2_A3CliCod = new int[1] ;
      P025L2_A1240PuestoCodigo = new String[] {""} ;
      A1242PuestoDescripSinAc = "" ;
      A13SecCodigo = "" ;
      A1240PuestoCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getareapuestopordescrip__default(),
         new Object[] {
             new Object[] {
            P025L2_A1242PuestoDescripSinAc, P025L2_A13SecCodigo, P025L2_A3CliCod, P025L2_A1240PuestoCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8SecCodigo ;
   private String AV11PuestoCodigo ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
   private boolean AV12existe ;
   private String AV9PuestoDescrip ;
   private String A1242PuestoDescripSinAc ;
   private boolean[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P025L2_A1242PuestoDescripSinAc ;
   private String[] P025L2_A13SecCodigo ;
   private int[] P025L2_A3CliCod ;
   private String[] P025L2_A1240PuestoCodigo ;
}

final  class getareapuestopordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025L2", "SELECT PuestoDescripSinAc, SecCodigo, CliCod, PuestoCodigo FROM Puesto WHERE (CliCod = ? and SecCodigo = ( ?)) AND (PuestoDescripSinAc = ( ?)) ORDER BY CliCod, SecCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

