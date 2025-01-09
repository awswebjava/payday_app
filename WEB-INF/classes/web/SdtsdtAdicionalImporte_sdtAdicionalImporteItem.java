package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtAdicionalImporte_sdtAdicionalImporteItem extends GxUserType
{
   public SdtsdtAdicionalImporte_sdtAdicionalImporteItem( )
   {
      this(  new ModelContext(SdtsdtAdicionalImporte_sdtAdicionalImporteItem.class));
   }

   public SdtsdtAdicionalImporte_sdtAdicionalImporteItem( ModelContext context )
   {
      super( context, "SdtsdtAdicionalImporte_sdtAdicionalImporteItem");
   }

   public SdtsdtAdicionalImporte_sdtAdicionalImporteItem( int remoteHandle ,
                                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtAdicionalImporte_sdtAdicionalImporteItem");
   }

   public SdtsdtAdicionalImporte_sdtAdicionalImporteItem( StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem struct )
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
               gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdicod") )
            {
               gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiVig") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig = GXutil.nullDate() ;
                  gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N = (byte)(0) ;
                  gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiImporte") )
            {
               gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "sdtAdicionalImporte.sdtAdicionalImporteItem" ;
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
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdicod", gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig)) && ( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N == 1 ) )
      {
         oWriter.writeElement("ConveAdiVig", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ConveAdiVig", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("ConveAdiImporte", GXutil.trim( GXutil.strNoRound( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte, 14, 2)));
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
      AddObjectProperty("CliPaiConve", gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio, false, false);
      AddObjectProperty("ConveAdicod", gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ConveAdiVig", sDateCnv, false, false);
      AddObjectProperty("ConveAdiImporte", gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte, false, false);
   }

   public short getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve ;
   }

   public void setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve( short value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio ;
   }

   public void setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio( String value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio = value ;
   }

   public String getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod ;
   }

   public void setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod( String value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod = value ;
   }

   public java.util.Date getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig ;
   }

   public void setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig( java.util.Date value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig = value ;
   }

   public java.math.BigDecimal getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte ;
   }

   public void setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte( java.math.BigDecimal value )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(0) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N = (byte)(1) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio = "" ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod = "" ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig = GXutil.nullDate() ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N = (byte)(1) ;
      gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N ;
   }

   public web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem Clone( )
   {
      return (web.SdtsdtAdicionalImporte_sdtAdicionalImporteItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem struct )
   {
      setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio(struct.getCliconvenio());
      setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod(struct.getConveadicod());
      if ( struct.gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N == 0 )
      {
         setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig(struct.getConveadivig());
      }
      setgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte(struct.getConveadiimporte());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem getStruct( )
   {
      web.StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem struct = new web.StructSdtsdtAdicionalImporte_sdtAdicionalImporteItem ();
      struct.setClipaiconve(getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio());
      struct.setConveadicod(getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod());
      if ( gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N == 0 )
      {
         struct.setConveadivig(getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig());
      }
      struct.setConveadiimporte(getgxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte());
      return struct ;
   }

   protected byte gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_N ;
   protected byte gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig_N ;
   protected short gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Clipaiconve ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadiimporte ;
   protected String gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Cliconvenio ;
   protected String gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadicod ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtsdtAdicionalImporte_sdtAdicionalImporteItem_Conveadivig ;
   protected boolean readElement ;
   protected boolean formatError ;
}

