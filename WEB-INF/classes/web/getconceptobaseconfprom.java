package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptobaseconfprom extends GXProcedure
{
   public getconceptobaseconfprom( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptobaseconfprom.class ), "" );
   }

   public getconceptobaseconfprom( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 ,
                           String aP2 ,
                           boolean aP3 )
   {
      getconceptobaseconfprom.this.aP4 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        byte[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             byte[] aP4 )
   {
      getconceptobaseconfprom.this.AV8CliCod = aP0;
      getconceptobaseconfprom.this.AV9ConCodigo = aP1;
      getconceptobaseconfprom.this.AV18EmpBaseTipo = aP2;
      getconceptobaseconfprom.this.AV19remuneradoEs = aP3;
      getconceptobaseconfprom.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01NK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01NK2_A26ConCodigo[0] ;
         A3CliCod = P01NK2_A3CliCod[0] ;
         A1797ConBaseLicProm = P01NK2_A1797ConBaseLicProm[0] ;
         A2192ConBaseAusProm = P01NK2_A2192ConBaseAusProm[0] ;
         A1798ConBaseFerProm = P01NK2_A1798ConBaseFerProm[0] ;
         A1799ConBaseHorExtProm = P01NK2_A1799ConBaseHorExtProm[0] ;
         if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
         {
            if ( AV19remuneradoEs )
            {
               AV17ConBaseLic = A1797ConBaseLicProm ;
            }
            else
            {
               AV17ConBaseLic = A2192ConBaseAusProm ;
            }
         }
         else
         {
            if ( GXutil.strcmp(AV18EmpBaseTipo, "feriado") == 0 )
            {
               AV17ConBaseLic = A1798ConBaseFerProm ;
            }
            else
            {
               AV17ConBaseLic = A1799ConBaseHorExtProm ;
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getconceptobaseconfprom.this.AV17ConBaseLic;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01NK2_A26ConCodigo = new String[] {""} ;
      P01NK2_A3CliCod = new int[1] ;
      P01NK2_A1797ConBaseLicProm = new byte[1] ;
      P01NK2_A2192ConBaseAusProm = new byte[1] ;
      P01NK2_A1798ConBaseFerProm = new byte[1] ;
      P01NK2_A1799ConBaseHorExtProm = new byte[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptobaseconfprom__default(),
         new Object[] {
             new Object[] {
            P01NK2_A26ConCodigo, P01NK2_A3CliCod, P01NK2_A1797ConBaseLicProm, P01NK2_A2192ConBaseAusProm, P01NK2_A1798ConBaseFerProm, P01NK2_A1799ConBaseHorExtProm
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV17ConBaseLic ;
   private byte A1797ConBaseLicProm ;
   private byte A2192ConBaseAusProm ;
   private byte A1798ConBaseFerProm ;
   private byte A1799ConBaseHorExtProm ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String AV18EmpBaseTipo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean AV19remuneradoEs ;
   private byte[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01NK2_A26ConCodigo ;
   private int[] P01NK2_A3CliCod ;
   private byte[] P01NK2_A1797ConBaseLicProm ;
   private byte[] P01NK2_A2192ConBaseAusProm ;
   private byte[] P01NK2_A1798ConBaseFerProm ;
   private byte[] P01NK2_A1799ConBaseHorExtProm ;
}

final  class getconceptobaseconfprom__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NK2", "SELECT ConCodigo, CliCod, ConBaseLicProm, ConBaseAusProm, ConBaseFerProm, ConBaseHorExtProm FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

