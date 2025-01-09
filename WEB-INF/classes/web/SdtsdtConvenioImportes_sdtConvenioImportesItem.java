package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtConvenioImportes_sdtConvenioImportesItem extends GxUserType
{
   public SdtsdtConvenioImportes_sdtConvenioImportesItem( )
   {
      this(  new ModelContext(SdtsdtConvenioImportes_sdtConvenioImportesItem.class));
   }

   public SdtsdtConvenioImportes_sdtConvenioImportesItem( ModelContext context )
   {
      super( context, "SdtsdtConvenioImportes_sdtConvenioImportesItem");
   }

   public SdtsdtConvenioImportes_sdtConvenioImportesItem( int remoteHandle ,
                                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtConvenioImportes_sdtConvenioImportesItem");
   }

   public SdtsdtConvenioImportes_sdtConvenioImportesItem( StructSdtsdtConvenioImportes_sdtConvenioImportesItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveImpVig") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig = GXutil.nullDate() ;
                  gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N = (byte)(0) ;
                  gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveImpTipo") )
            {
               gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveImporte") )
            {
               gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "sdtConvenioImportes.sdtConvenioImportesItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig)) && ( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N == 1 ) )
      {
         oWriter.writeElement("CliConveImpVig", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CliConveImpVig", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("CliConveImpTipo", gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveImporte", GXutil.trim( GXutil.strNoRound( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliPaiConve", gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("CliConveImpVig", sDateCnv, false, false);
      AddObjectProperty("CliConveImpTipo", gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo, false, false);
      AddObjectProperty("CliConveImporte", gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte, false, false);
   }

   public short getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve ;
   }

   public void setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve( short value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio ;
   }

   public void setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio( String value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio = value ;
   }

   public java.util.Date getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig ;
   }

   public void setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig( java.util.Date value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig = value ;
   }

   public String getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo ;
   }

   public void setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo( String value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo = value ;
   }

   public java.math.BigDecimal getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte ;
   }

   public void setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte( java.math.BigDecimal value )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N = (byte)(1) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio = "" ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig = GXutil.nullDate() ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N = (byte)(1) ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo = "" ;
      gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N ;
   }

   public web.SdtsdtConvenioImportes_sdtConvenioImportesItem Clone( )
   {
      return (web.SdtsdtConvenioImportes_sdtConvenioImportesItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtConvenioImportes_sdtConvenioImportesItem struct )
   {
      setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio(struct.getCliconvenio());
      if ( struct.gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N == 0 )
      {
         setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig(struct.getCliconveimpvig());
      }
      setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo(struct.getCliconveimptipo());
      setgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte(struct.getCliconveimporte());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtConvenioImportes_sdtConvenioImportesItem getStruct( )
   {
      web.StructSdtsdtConvenioImportes_sdtConvenioImportesItem struct = new web.StructSdtsdtConvenioImportes_sdtConvenioImportesItem ();
      struct.setClipaiconve(getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio());
      if ( gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N == 0 )
      {
         struct.setCliconveimpvig(getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig());
      }
      struct.setCliconveimptipo(getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo());
      struct.setCliconveimporte(getgxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte());
      return struct ;
   }

   protected byte gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_N ;
   protected byte gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig_N ;
   protected short gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Clipaiconve ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimporte ;
   protected String gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconvenio ;
   protected String gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimptipo ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtsdtConvenioImportes_sdtConvenioImportesItem_Cliconveimpvig ;
   protected boolean readElement ;
   protected boolean formatError ;
}

