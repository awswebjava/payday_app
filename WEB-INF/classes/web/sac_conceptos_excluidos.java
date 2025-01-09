package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sac_conceptos_excluidos extends GXProcedure
{
   public sac_conceptos_excluidos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sac_conceptos_excluidos.class ), "" );
   }

   public sac_conceptos_excluidos( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 boolean aP1 ,
                                                 boolean aP2 )
   {
      sac_conceptos_excluidos.this.aP3 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        boolean aP1 ,
                        boolean aP2 ,
                        GXSimpleCollection<String>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             boolean aP1 ,
                             boolean aP2 ,
                             GXSimpleCollection<String>[] aP3 )
   {
      sac_conceptos_excluidos.this.AV11CliCod = aP0;
      sac_conceptos_excluidos.this.AV13noAplican = aP1;
      sac_conceptos_excluidos.this.AV12ExtraMensuales = aP2;
      sac_conceptos_excluidos.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9desde_TipoConCod = "NRE_ARG" ;
      AV8hasta_TipoConCod = "REM_ARG" ;
      if ( AV13noAplican )
      {
         /* Using cursor P01GB2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV9desde_TipoConCod, AV8hasta_TipoConCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1539ConSacDeven = P01GB2_A1539ConSacDeven[0] ;
            A37TipoConCod = P01GB2_A37TipoConCod[0] ;
            A3CliCod = P01GB2_A3CliCod[0] ;
            A26ConCodigo = P01GB2_A26ConCodigo[0] ;
            AV10ConCodigo.add(A26ConCodigo, 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      if ( AV12ExtraMensuales )
      {
         /* Using cursor P01GB3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), AV9desde_TipoConCod, AV8hasta_TipoConCod});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1539ConSacDeven = P01GB3_A1539ConSacDeven[0] ;
            A37TipoConCod = P01GB3_A37TipoConCod[0] ;
            A3CliCod = P01GB3_A3CliCod[0] ;
            A26ConCodigo = P01GB3_A26ConCodigo[0] ;
            AV10ConCodigo.add(A26ConCodigo, 0);
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = sac_conceptos_excluidos.this.AV10ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9desde_TipoConCod = "" ;
      AV8hasta_TipoConCod = "" ;
      scmdbuf = "" ;
      P01GB2_A1539ConSacDeven = new byte[1] ;
      P01GB2_A37TipoConCod = new String[] {""} ;
      P01GB2_A3CliCod = new int[1] ;
      P01GB2_A26ConCodigo = new String[] {""} ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      P01GB3_A1539ConSacDeven = new byte[1] ;
      P01GB3_A37TipoConCod = new String[] {""} ;
      P01GB3_A3CliCod = new int[1] ;
      P01GB3_A26ConCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sac_conceptos_excluidos__default(),
         new Object[] {
             new Object[] {
            P01GB2_A1539ConSacDeven, P01GB2_A37TipoConCod, P01GB2_A3CliCod, P01GB2_A26ConCodigo
            }
            , new Object[] {
            P01GB3_A1539ConSacDeven, P01GB3_A37TipoConCod, P01GB3_A3CliCod, P01GB3_A26ConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1539ConSacDeven ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV9desde_TipoConCod ;
   private String AV8hasta_TipoConCod ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private boolean AV13noAplican ;
   private boolean AV12ExtraMensuales ;
   private GXSimpleCollection<String>[] aP3 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01GB2_A1539ConSacDeven ;
   private String[] P01GB2_A37TipoConCod ;
   private int[] P01GB2_A3CliCod ;
   private String[] P01GB2_A26ConCodigo ;
   private byte[] P01GB3_A1539ConSacDeven ;
   private String[] P01GB3_A37TipoConCod ;
   private int[] P01GB3_A3CliCod ;
   private String[] P01GB3_A26ConCodigo ;
   private GXSimpleCollection<String> AV10ConCodigo ;
}

final  class sac_conceptos_excluidos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GB2", "SELECT ConSacDeven, TipoConCod, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ? and ConSacDeven = 0 and TipoConCod >= ( ?)) AND (TipoConCod <= ( ?)) ORDER BY CliCod, ConSacDeven ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01GB3", "SELECT ConSacDeven, TipoConCod, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ?) AND (TipoConCod >= ( ?)) AND (TipoConCod <= ( ?)) AND (ConSacDeven >= 2) AND (ConSacDeven <= 12) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

