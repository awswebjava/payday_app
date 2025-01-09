package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_variableValores_sdt_variableValoresItem extends GxUserType
{
   public Sdtsdt_variableValores_sdt_variableValoresItem( )
   {
      this(  new ModelContext(Sdtsdt_variableValores_sdt_variableValoresItem.class));
   }

   public Sdtsdt_variableValores_sdt_variableValoresItem( ModelContext context )
   {
      super( context, "Sdtsdt_variableValores_sdt_variableValoresItem");
   }

   public Sdtsdt_variableValores_sdt_variableValoresItem( int remoteHandle ,
                                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_variableValores_sdt_variableValoresItem");
   }

   public Sdtsdt_variableValores_sdt_variableValoresItem( StructSdtsdt_variableValores_sdt_variableValoresItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliId") )
            {
               gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVRetro") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro = GXutil.nullDate() ;
                  gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N = (byte)(0) ;
                  gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliVig") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig = GXutil.nullDate() ;
                  gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N = (byte)(0) ;
                  gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OpeCliValor") )
            {
               gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor = oReader.getValue() ;
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
         sName = "sdt_variableValores.sdt_variableValoresItem" ;
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
      oWriter.writeElement("OpeCliId", gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro)) && ( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N == 1 ) )
      {
         oWriter.writeElement("OpeCliVRetro", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("OpeCliVRetro", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig)) && ( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N == 1 ) )
      {
         oWriter.writeElement("OpeCliVig", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("OpeCliVig", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("OpeCliValor", gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("OpeCliId", gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("OpeCliVRetro", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("OpeCliVig", sDateCnv, false, false);
      AddObjectProperty("OpeCliValor", gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor, false, false);
   }

   public String getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid ;
   }

   public void setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid( String value )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro ;
   }

   public void setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro( java.util.Date value )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig ;
   }

   public void setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig( java.util.Date value )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig = value ;
   }

   public String getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor ;
   }

   public void setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor( String value )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid = "" ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N = (byte)(1) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro = GXutil.nullDate() ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N = (byte)(1) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig = GXutil.nullDate() ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N = (byte)(1) ;
      gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N ;
   }

   public web.Sdtsdt_variableValores_sdt_variableValoresItem Clone( )
   {
      return (web.Sdtsdt_variableValores_sdt_variableValoresItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_variableValores_sdt_variableValoresItem struct )
   {
      setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid(struct.getOpecliid());
      if ( struct.gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N == 0 )
      {
         setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro(struct.getOpeclivretro());
      }
      if ( struct.gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N == 0 )
      {
         setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig(struct.getOpeclivig());
      }
      setgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor(struct.getOpeclivalor());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_variableValores_sdt_variableValoresItem getStruct( )
   {
      web.StructSdtsdt_variableValores_sdt_variableValoresItem struct = new web.StructSdtsdt_variableValores_sdt_variableValoresItem ();
      struct.setOpecliid(getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid());
      if ( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N == 0 )
      {
         struct.setOpeclivretro(getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro());
      }
      if ( gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N == 0 )
      {
         struct.setOpeclivig(getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig());
      }
      struct.setOpeclivalor(getgxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_N ;
   protected byte gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro_N ;
   protected byte gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opecliid ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivretro ;
   protected java.util.Date gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivig ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_variableValores_sdt_variableValoresItem_Opeclivalor ;
}

