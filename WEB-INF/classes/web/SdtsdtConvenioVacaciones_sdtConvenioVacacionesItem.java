package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem extends GxUserType
{
   public SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem( )
   {
      this(  new ModelContext(SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem.class));
   }

   public SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem( ModelContext context )
   {
      super( context, "SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem");
   }

   public SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem( int remoteHandle ,
                                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem");
   }

   public SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem( StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem struct )
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
               gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVig") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig = GXutil.nullDate() ;
                  gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N = (byte)(0) ;
                  gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacDesAnt") )
            {
               gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacHasAnt") )
            {
               gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVacDias") )
            {
               gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdtConvenioVacaciones.sdtConvenioVacacionesItem" ;
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
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig)) && ( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N == 1 ) )
      {
         oWriter.writeElement("CliConveVig", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CliConveVig", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("CliConveVacDesAnt", GXutil.trim( GXutil.str( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveVacHasAnt", GXutil.trim( GXutil.str( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConveVacDias", GXutil.trim( GXutil.str( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias, 2, 0)));
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
      AddObjectProperty("CliPaiConve", gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve, false, false);
      AddObjectProperty("CliConvenio", gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("CliConveVig", sDateCnv, false, false);
      AddObjectProperty("CliConveVacDesAnt", gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant, false, false);
      AddObjectProperty("CliConveVacHasAnt", gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant, false, false);
      AddObjectProperty("CliConveVacDias", gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias, false, false);
   }

   public short getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve ;
   }

   public void setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve( short value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve = value ;
   }

   public String getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio ;
   }

   public void setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio( String value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio = value ;
   }

   public java.util.Date getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig ;
   }

   public void setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig( java.util.Date value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig = value ;
   }

   public byte getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant ;
   }

   public void setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant( byte value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant = value ;
   }

   public byte getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant ;
   }

   public void setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant( byte value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant = value ;
   }

   public byte getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias ;
   }

   public void setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias( byte value )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(0) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N = (byte)(1) ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio = "" ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig = GXutil.nullDate() ;
      gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N ;
   }

   public web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem Clone( )
   {
      return (web.SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem struct )
   {
      setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio(struct.getCliconvenio());
      if ( struct.gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N == 0 )
      {
         setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig(struct.getCliconvevig());
      }
      setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant(struct.getCliconvevacdesant());
      setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant(struct.getCliconvevachasant());
      setgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias(struct.getCliconvevacdias());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem getStruct( )
   {
      web.StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem struct = new web.StructSdtsdtConvenioVacaciones_sdtConvenioVacacionesItem ();
      struct.setClipaiconve(getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio());
      if ( gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N == 0 )
      {
         struct.setCliconvevig(getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig());
      }
      struct.setCliconvevacdesant(getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant());
      struct.setCliconvevachasant(getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant());
      struct.setCliconvevacdias(getgxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias());
      return struct ;
   }

   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_N ;
   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig_N ;
   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdesant ;
   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevachasant ;
   protected byte gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevacdias ;
   protected short gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Clipaiconve ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvenio ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtsdtConvenioVacaciones_sdtConvenioVacacionesItem_Cliconvevig ;
   protected boolean readElement ;
   protected boolean formatError ;
}

