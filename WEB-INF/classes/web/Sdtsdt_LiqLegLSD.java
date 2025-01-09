package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_LiqLegLSD extends GxUserType
{
   public Sdtsdt_LiqLegLSD( )
   {
      this(  new ModelContext(Sdtsdt_LiqLegLSD.class));
   }

   public Sdtsdt_LiqLegLSD( ModelContext context )
   {
      super( context, "Sdtsdt_LiqLegLSD");
   }

   public Sdtsdt_LiqLegLSD( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_LiqLegLSD");
   }

   public Sdtsdt_LiqLegLSD( StructSdtsdt_LiqLegLSD struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDLegId") )
            {
               gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDLegCBU") )
            {
               gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDLegDiasLiq") )
            {
               gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDLegFecPag") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag = GXutil.nullDate() ;
                  gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N = (byte)(0) ;
                  gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDLegCony") )
            {
               gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDLegHijos") )
            {
               gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDDepRev") )
            {
               gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqLSDForPag") )
            {
               gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag = oReader.getValue() ;
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
         sName = "sdt_LiqLegLSD" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("ImpLiqLSDLegId", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDLegCBU", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDLegDiasLiq", GXutil.trim( GXutil.str( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag)) && ( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N == 1 ) )
      {
         oWriter.writeElement("ImpLiqLSDLegFecPag", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ImpLiqLSDLegFecPag", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("ImpLiqLSDLegCony", GXutil.booltostr( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDLegHijos", GXutil.trim( GXutil.str( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDDepRev", gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqLSDForPag", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag);
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
      AddObjectProperty("ImpLiqLSDLegId", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid, false, false);
      AddObjectProperty("ImpLiqLSDLegCBU", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu, false, false);
      AddObjectProperty("ImpLiqLSDLegDiasLiq", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ImpLiqLSDLegFecPag", sDateCnv, false, false);
      AddObjectProperty("ImpLiqLSDLegCony", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony, false, false);
      AddObjectProperty("ImpLiqLSDLegHijos", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos, false, false);
      AddObjectProperty("ImpLiqLSDDepRev", gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev, false, false);
      AddObjectProperty("ImpLiqLSDForPag", gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag, false, false);
   }

   public String getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid ;
   }

   public void setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid( String value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid = value ;
   }

   public String getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu ;
   }

   public void setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu( String value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu = value ;
   }

   public short getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq ;
   }

   public void setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq( short value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag ;
   }

   public void setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag( java.util.Date value )
   {
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag = value ;
   }

   public boolean getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony ;
   }

   public void setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony( boolean value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony = value ;
   }

   public byte getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos ;
   }

   public void setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos( byte value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos = value ;
   }

   public String getgxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev ;
   }

   public void setgxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev( String value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev = value ;
   }

   public String getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag ;
   }

   public void setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag( String value )
   {
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(0) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid = "" ;
      gxTv_Sdtsdt_LiqLegLSD_N = (byte)(1) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu = "" ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag = GXutil.nullDate() ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N = (byte)(1) ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev = "" ;
      gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_LiqLegLSD_N ;
   }

   public web.Sdtsdt_LiqLegLSD Clone( )
   {
      return (web.Sdtsdt_LiqLegLSD)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_LiqLegLSD struct )
   {
      setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid(struct.getImpliqlsdlegid());
      setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu(struct.getImpliqlsdlegcbu());
      setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq(struct.getImpliqlsdlegdiasliq());
      if ( struct.gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N == 0 )
      {
         setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag(struct.getImpliqlsdlegfecpag());
      }
      setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony(struct.getImpliqlsdlegcony());
      setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos(struct.getImpliqlsdleghijos());
      setgxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev(struct.getImpliqlsddeprev());
      setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag(struct.getImpliqlsdforpag());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_LiqLegLSD getStruct( )
   {
      web.StructSdtsdt_LiqLegLSD struct = new web.StructSdtsdt_LiqLegLSD ();
      struct.setImpliqlsdlegid(getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid());
      struct.setImpliqlsdlegcbu(getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu());
      struct.setImpliqlsdlegdiasliq(getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq());
      if ( gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N == 0 )
      {
         struct.setImpliqlsdlegfecpag(getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag());
      }
      struct.setImpliqlsdlegcony(getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony());
      struct.setImpliqlsdleghijos(getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos());
      struct.setImpliqlsddeprev(getgxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev());
      struct.setImpliqlsdforpag(getgxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_LiqLegLSD_N ;
   protected byte gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag_N ;
   protected byte gxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos ;
   protected short gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid ;
   protected String gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu ;
   protected String gxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev ;
   protected String gxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag ;
   protected boolean gxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony ;
   protected boolean readElement ;
   protected boolean formatError ;
}

