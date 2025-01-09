package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem extends GxUserType
{
   public Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem( )
   {
      this(  new ModelContext(Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem.class));
   }

   public Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem( ModelContext context )
   {
      super( context, "Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem");
   }

   public Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem( int remoteHandle ,
                                                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem");
   }

   public Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem( StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLiqSinCausa") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLiqSinPre") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLTipEgr") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLConOrd") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLOrdejec") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec = (long)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdt_concepto.sdt_conceptoItem.TipoLiquidacionItem" ;
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
      oWriter.writeElement("TLiqCod", gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLiqSinCausa", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLiqSinPre", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLTipEgr", gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLConOrd", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLOrdejec", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec, 12, 0)));
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
      AddObjectProperty("TLiqCod", gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod, false, false);
      AddObjectProperty("ConTLiqSinCausa", gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa, false, false);
      AddObjectProperty("ConTLiqSinPre", gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre, false, false);
      AddObjectProperty("ConTLTipEgr", gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr, false, false);
      AddObjectProperty("ConTLConOrd", gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord, false, false);
      AddObjectProperty("ConTLOrdejec", gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec, false, false);
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr = value ;
   }

   public short getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord = value ;
   }

   public long getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec( long value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N ;
   }

   public web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem Clone( )
   {
      return (web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem struct )
   {
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod(struct.getTliqcod());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa(struct.getContliqsincausa());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre(struct.getContliqsinpre());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr(struct.getContltipegr());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord(struct.getContlconord());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec(struct.getContlordejec());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem getStruct( )
   {
      web.StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem struct = new web.StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem ();
      struct.setTliqcod(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod());
      struct.setContliqsincausa(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa());
      struct.setContliqsinpre(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre());
      struct.setContltipegr(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr());
      struct.setContlconord(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord());
      struct.setContlordejec(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_N ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlconord ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contlordejec ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Tliqcod ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contltipegr ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsincausa ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem_Contliqsinpre ;
   protected boolean readElement ;
   protected boolean formatError ;
}

